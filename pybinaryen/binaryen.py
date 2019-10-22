"""
Python interface to the binaryen webassembly library (https://github.com/WebAssembly/binaryen)

Author: Irmen de Jong (irmen@razorvine.net)
Software license: "MIT software license". See http://opensource.org/licenses/MIT
"""

__version__ = "1.0"

from _binaryen import ffi, lib


# the function names in this module are without the 'Binaryen' prefix.
def import_functions():
    import inspect
    _current_module = __import__(__name__)
    for name, member in inspect.getmembers(lib):
        if inspect.isroutine(member):
            if name.startswith("Binaryen"):
                name = name[8:]
        setattr(_current_module, name, member)

import_functions()
del import_functions
