import subprocess
from cffi import FFI

# This version of the script can be used to build against the *static* library
# that is distributed in the official releases from the project.
# For instance: https://github.com/WebAssembly/binaryen/releases/tag/version_105

# path where the binary release package from Binaryen is extracted to.
binaryen_extract_path = "./binaryen-version_105"


def parse_header_file():
    print("Processing binaryen-c.h header file...")
    header_location = binaryen_extract_path + "/include/binaryen-c.h"
    proc = subprocess.Popen(["cpp", "-nostdinc", "-E", "-P", header_location], stdout=subprocess.PIPE, stderr=subprocess.DEVNULL)
    headerfile_src = proc.stdout.read().decode("utf-8").splitlines()

    if not headerfile_src:
        raise IOError("faulty header file input")

    lines = []
    src_lines = iter(headerfile_src)
    try:
        while True:
            line = next(src_lines).strip()
            if "deprecated" in line:
                while ";" not in line:
                    line = next(src_lines).strip()
            else:
                lines.append(line)
    except StopIteration:
        pass

    headerfile = "\n".join(lines)
    ffi_c_source="""
#include <binaryen-c.h>
"""
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
