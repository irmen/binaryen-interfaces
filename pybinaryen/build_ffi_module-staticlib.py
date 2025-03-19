import subprocess
from cffi import FFI

# This version of the script can be used to build against the *static* library
# that is distributed in the official releases from the project.
# For instance: https://github.com/WebAssembly/binaryen/releases/tag/version_105

# path where the binary release package from Binaryen is extracted to.
binaryen_extract_path = "./binaryen-version_122"


def cleanup_headers(headers):
    lines = []
    structs = []
    src_lines = iter(headers.splitlines())
    try:
        while True:
            line = next(src_lines).strip()
            if "deprecated" in line:
                while ";" not in line:
                    line = next(src_lines).strip()
            elif line==";":
                continue
            #elif "__attribute__" in line:
            #    raise SystemExit("TODO FIX HEADER LINE: " + line) # XXX
            elif line.startswith("typedef struct "):
                parts = line.split()
                if parts[2].endswith('*'):
                    structs.append(parts[2][:-1])
                lines.append(line)
            else:
                lines.append(line)
    except StopIteration:
        pass
    
    return "\n".join(lines), structs


def parse_header_file():
    print("Processing binaryen-c.h header file...")
    header_location = binaryen_extract_path + "/include/binaryen-c.h"
    proc1 = subprocess.Popen(["cpp", "-nostdinc", "-E", "-P", header_location], stdout=subprocess.PIPE, stderr=subprocess.DEVNULL)
    # proc2 = subprocess.Popen(["clang-format", "-style", "{BasedOnStyle: llvm, ColumnLimit: 0, AlignAfterOpenBracket: BlockIndent}"], stdin=proc1.stdout, stdout=subprocess.PIPE, stderr=subprocess.DEVNULL)
    headerfile = proc1.stdout.read().decode("utf-8")

    if not headerfile:
        raise IOError("faulty header file input")

    headerfile, structs = cleanup_headers(headerfile)
    structs_source = ""
    for struct in structs:
        structs_source += "struct " + struct + " { };\n"
    headerfile = structs_source + headerfile
    ffi_c_source = structs_source + "#include <binaryen-c.h>\n"
    return headerfile, ffi_c_source


headerfile, ffi_c_source = parse_header_file()
ffibuilder = FFI()
ffibuilder.cdef(headerfile)
ffibuilder.set_source("_binaryen", ffi_c_source,
                      define_macros=[('BUILD_STATIC_LIBRARY', '1')],
                      include_dirs=[binaryen_extract_path+"/include"],
                      library_dirs=[binaryen_extract_path+"/lib"],
                      libraries=['binaryen', 'stdc++'])


if __name__ == "__main__":
    ffibuilder.compile(verbose=True)
