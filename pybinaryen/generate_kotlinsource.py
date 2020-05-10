import inspect
from build_ffi_module import parse_header_file
import binaryen


def ctype_to_kotlin(ctype):
    ctype = ctype.strip()
    if ctype in ("void*", "uintptr_t"):
        return "Pointer"
    elif ctype in ("char*", "char *", "const char*", "const char *"):
        return "String"
    elif ctype == "char**":
        return "Array<String>"
    elif ctype in ("int", "size_t", "uint32_t", "int32_t", "BinaryenIndex"):
        return "Int"
    elif ctype in ("uint64_t", "int64_t"):
        return "Long"
    elif ctype == "void":
        return ""
    elif ctype == "float":
        return "Float"
    elif ctype == "double":
        return "Double"
    elif ctype in ("uint8_t", "int8_t"):
        return "Byte"
    elif ctype in ("uint8_t*", "int8_t*"):
        return "ByteArray"
    elif ctype in ("BinaryenType*", "BinaryenIndex*"):
        return "LongArray"
    elif ctype.endswith("*"):
        return "Array<{}>".format(ctype[:-1])
    elif ctype.startswith(("Binary", "Relooper", "ExpressionRunner")):
        return ctype
    else:
        raise NotImplementedError("ctype: '"+ctype+"'")


def create_typedefs(headerlines):
    for line in headerlines:
        words = line.split()
        if words[0] == "struct" and words[2] == "{":
            print("class {}: Structure()".format(words[1]))
        elif words[0] == "typedef":
            if words[1] == "struct":
                if words[2].endswith("*"):
                    typename = words[3].rstrip(";")
                    print("typealias", typename, "= Pointer")
                elif words[3] == "{":
                    print("class {}: Structure()".format(words[2]))
            else:
                typename = words[2].rstrip(";")
                if typename=="BinaryenType":
                    ctype = "Long"      #  not Pointer...
                else:
                    ctype = ctype_to_kotlin(words[1])
                print("typealias", typename, "=", ctype)


def create_kotlin():
    headerlines = parse_header_file()[0].splitlines()
    print("""
// ---------------------- KOTLIN SOURCE -----------------
import com.sun.jna.Library
import com.sun.jna.Native
import com.sun.jna.Platform
import com.sun.jna.Pointer
import com.sun.jna.Structure

// typealiases:""")
    create_typedefs(headerlines)

    print("\n// functions:")

    functions = inspect.getmembers(binaryen.lib, inspect.isroutine)
    for name, func in functions:
        args, result = signature(name, func, headerlines)
        if result:
            print("fun {}({}): {}".format(name, args, result))
        else:
            print("fun {}({})".format(name, args))


def func_from_header(name, headerlines):
    lines = iter(headerlines)
    search = name+"("
    funclines = []
    previous_line = ""
    while True:
        line = next(lines)
        if line.startswith(search):
            # the return type is on the previous line.
            line = previous_line + " " + line
        if search in line:
            line = line.strip()
            funclines.append(line)
            while not line.endswith(";"):
                line = next(lines)
                funclines.append(line.strip())
            break
        previous_line = line
    return funclines


def get_param_name_and_ctype(hparam):
    hparam = hparam.replace("const ", "")
    ptype, name = hparam.rsplit(" ", 1)
    ptype = ptype.strip()
    name = name.split("[")[0].strip()
    if name == "in":
        name = "`{}`".format(name)
    if ptype.startswith("struct"):
        ptype = ptype[6:].lstrip()
    return name, ptype


def signature(funcname, func, headerlines):
    ctype = binaryen.ffi.typeof(func)
    if ctype.kind != "function":
        raise TypeError("expected function")
    lines = func_from_header(funcname, headerlines)
    cargs = ctype.args
    argspec = ""
    if cargs:
        funcsource = " ".join(lines)
        open_paren = funcsource.index("(")
        close_paren = funcsource.index(")")
        header_params = funcsource[open_paren+1:close_paren].split(",")
        if len(header_params) != len(cargs):
            raise ValueError("invalid number of args in header")
        kotlin_params = []
        for hparam in header_params:
            param_name, param_ctype = get_param_name_and_ctype(hparam)
            param_ktype = ctype_to_kotlin(param_ctype)
            if param_ctype.endswith("*") and not param_ctype.startswith("char"):
                param_ktype += "?"
            karg = "{}: {}".format(param_name, param_ktype)
            kotlin_params.append(karg)
        argspec = ", ".join(kotlin_params)
    cresult = ctype.result
    resultspec = ""
    if cresult.cname != "void":
        if cresult.kind == "primitive":
            hctype = lines[0].partition(funcname+"(")[0]
            resultspec = ctype_to_kotlin(hctype)
        elif cresult.kind in ("struct", "pointer"):
            hctype = lines[0].partition(funcname+"(")[0]
            if hctype.startswith("struct"):
                hctype = hctype[6:].lstrip()
            resultspec = ctype_to_kotlin(hctype)
        else:
            raise NotImplementedError("strange cresult kind", cresult.kind)
    return argspec, resultspec


if __name__ == "__main__":
    create_kotlin()
