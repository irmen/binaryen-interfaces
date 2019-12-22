[![saythanks](https://img.shields.io/badge/say-thanks-ff69b4.svg)](https://saythanks.io/to/irmen)
[![Latest Version](https://img.shields.io/pypi/v/pybinaryen.svg)](https://pypi.python.org/pypi/pybinaryen/)


# Python interface to the Binaryen library

This module provides a Python interface to the
[binaryen](https://github.com/WebAssembly/binaryen) webassembly library.

That library has to be installed separately, make sure it is available on your system as a shared library.
You may need to add something to your link library search path to let python pick it up.

*Requires Python 3.5 or newer.  Also works on pypy3 (because it uses cffi).*

Software license: MIT

## Example

Running the following code:
```python
import binaryen

module = binaryen.ModuleCreate()
params = binaryen.TypeCreate([binaryen.TypeInt32(), binaryen.TypeInt32()], 2)
results = binaryen.TypeInt32()
x = binaryen.LocalGet(module, 0, binaryen.TypeInt32())
y = binaryen.LocalGet(module, 1, binaryen.TypeInt32())
add = binaryen.Binary(module, binaryen.AddInt32(), x, y)
adder = binaryen.AddFunction(module, b"adder", params, results, binaryen.ffi.NULL, 0, add)
binaryen.ModulePrint(module)
binaryen.ModuleDispose(module)
```

results in the following Webasm Text output:
```
(module
 (type $i32_i32_=>_i32 (func (param i32 i32) (result i32)))
 (func $adder (; 0 ;) (param $0 i32) (param $1 i32) (result i32)
  (i32.add
   (local.get $0)
   (local.get $1)
  )
 )
)
```
