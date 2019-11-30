import os
import subprocess
from cffi import FFI


def parse_header_file():
    usesysteminstalled = True
    print("Processing binaryen-c.h header file...")
    header_location = "/usr/include/binaryen-c.h"
    if not os.path.isfile(header_location):
        header_location = "/usr/local/include/binaryen-c.h"
        if not os.path.isfile(header_location):
            raise FileNotFoundError("Can't find the header file")
            # header_location = "binaryen-c-pp.h"
            # usesysteminstalled = False

    if usesysteminstalled:
        print("(Using system installed version)")
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
    else:
        headerfile = open(header_location, "rt").read()
        ffi_c_source = headerfile
    return headerfile, ffi_c_source


headerfile, ffi_c_source = parse_header_file()
ffibuilder = FFI()
ffibuilder.cdef(headerfile)
ffibuilder.set_source("_binaryen", ffi_c_source, libraries=['binaryen'])


if __name__ == "__main__":
    ffibuilder.compile(verbose=True)
