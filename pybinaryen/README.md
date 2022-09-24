[![Latest Version](https://img.shields.io/pypi/v/pybinaryen.svg)](https://pypi.python.org/pypi/pybinaryen/)


# Python interface to the Binaryen library

This module provides a Python interface to the
[binaryen](https://github.com/WebAssembly/binaryen) webassembly library.

That library has to be installed separately, make sure it is available on your system as a shared library.
You may need to add something to your link library search path to let python pick it up.

*Requires Python 3.6 or newer.  Also works on pypy3 (because it uses cffi).*
*This release is compatible with binaryen library version 108.*

Software license: MIT

## Installation

This Python package expects binaryen to be installed in `/usr/include/` and `/usr/lib/`. You can do so by [building from source](https://github.com/WebAssembly/binaryen) or by downloading a release from https://github.com/WebAssembly/binaryen/releases and installing it manually.

Manual installation can be done by extracting the archive, and copying (or symlinking) the files in it to the appropriate location in `/usr/`.

As an example here is what this might look like in GitHub Actions CI:

```yaml
    - name: Install Binaryen
      run: |
        wget https://github.com/WebAssembly/binaryen/releases/download/version_110/binaryen-version_110-x86_64-linux.tar.gz
        tar -xf binaryen-version_110-x86_64-linux.tar.gz
        sudo ln -s $PWD/binaryen-version_110/include/binaryen-c.h /usr/include/binaryen-c.h
        sudo ln -s $PWD/binaryen-version_110/include/wasm-delegations.def /usr/include/wasm-delegations.def
        sudo ln -s $PWD/binaryen-version_110/lib/libbinaryen.a /usr/lib/libbinaryen.a
```

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
