import os
import subprocess
from cffi import FFI

cpreprocess = True
print("Processing binaryen-c.h header file...")
header_location = "/usr/include/binaryen-c.h"
if not os.path.isfile(header_location):
    header_location = "/usr/local/include/binaryen-c.h"
    if not os.path.isfile(header_location):
        print("(Can't find system installed version, using prepackaged version)")
        header_location = "binaryen-c-pp.h"
        cpreprocess = False
    
if cpreprocess:
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
else:
    headerfile = open(header_location, "rt").read()
    
    
ffibuilder = FFI()
ffibuilder.cdef(headerfile)
 
ffibuilder.set_source("_binaryen", """
    #include "binaryen-c.h" 
""",
                      libraries=['binaryen']
                      )


if __name__ == "__main__":
    ffibuilder.compile(verbose=True)
