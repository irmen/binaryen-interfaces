from build_ffi_module import parse_header_file

print("""
// ---------------------- KOTLIN SOURCE -----------------
import com.sun.jna.Library
import com.sun.jna.Native
import com.sun.jna.Platform
import com.sun.jna.Pointer
import com.sun.jna.Structure

""")
print("// typealiases:")
headerlines = parse_header_file()[0].splitlines()


def ctype_to_kotlin(ctype):
    if ctype == "void*":
        return "Pointer"
    elif ctype == "char*":
        return "String"
    elif ctype == "char**":
        return "Array<String>"
    elif ctype in ("int", "size_t", "uint32_t", "int32_t"):
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
        return "IntArray"
    elif ctype.endswith("*"):
        return "Array<{}>".format(ctype[:-1])
    elif ctype.startswith(("Binary", "Relooper")):
        return ctype
    else:
        raise NotImplementedError("ctype: "+ctype)


def process_struct(line, lines, output):
    _, _, name = line.partition("struct")
    if name.endswith("{"):
        name = name[:-1].strip()
    if output:
        print("class {}: Structure()".format(name))
    braces_count = 1
    while braces_count > 0:
        line = next(lines)
        if "{" in line:
            braces_count += 1
        if "}" in line:
            braces_count -= 1


def process_function(line):
    if line.startswith("struct "):
        line = line[7:]
    funcpart, _, paramspart = line.partition("(")
    paramsstrs = paramspart[:-2].split(",")
    if paramsstrs in ([], [""], ["void"]):
        params = []
    else:
        params = []
        for p in paramsstrs:
            p = p.strip()
            if p.startswith("struct "):
                p = p[7:]
            ctype, pname = p.split()
            if pname == "in":
                pname = "`in`"
            if "[" in pname:
                pname, _, _ = pname.partition("[")
                ctype += "*"
                ktype = ctype_to_kotlin(ctype)
            else:
                ktype = ctype_to_kotlin(ctype)
                if ctype.endswith("*") and not ctype.startswith("char"):
                    ktype += "?"
            params.append("{}: {}".format(pname, ktype))
    params = ", ".join(params)
    ctype, funcname = funcpart.split(" ", maxsplit=2)
    ktype = ctype_to_kotlin(ctype)
    if ktype:
        print("fun {}({}): {}".format(funcname, params, ktype))
    else:
        print("fun {}({})".format(funcname, params))


lines = iter(headerlines)
try:
    while True:
        line = next(lines)
        if line.startswith("struct") and line.endswith("{"):
            _, name, _ = line.split(" ")
            print("class {}: Structure()".format(name))
            while "}" not in line:
                line = next(lines)
        elif line.startswith("typedef"):
            if "struct" in line:
                process_struct(line, lines, True)
            else:
                _, ctype, name = line.split(" ")
                name = name[:-1]
                print("typealias {} = {}".format(name, ctype_to_kotlin(ctype)))
except StopIteration:
    pass
print("\n")


lines = iter(headerlines)
try:
    while True:
        line = next(lines)
        line = line.replace("const ", "").strip()
        if (line.startswith("struct") and "{" not in line) or ("(" in line):
            while not line.endswith(";"):
                contline = next(lines)
                contline = contline.replace("const ", "").strip()
                line += contline
            process_function(line)
        elif "struct" in line:
            process_struct(line, lines, False)
        elif not line.startswith("typedef"):
                line += " "
                while not line.endswith(";"):
                    contline = next(lines)
                    contline = contline.replace("const ", "").strip()
                    line += contline
                process_function(line)
except StopIteration:
    pass
print("\n")
