[![saythanks](https://img.shields.io/badge/say-thanks-ff69b4.svg)](https://saythanks.io/to/irmen)


# Kotlin/JVM interface to the Binaryen library

This module provides a Kotlin/JVM interface to the
[binaryen](https://github.com/WebAssembly/binaryen) webassembly library.

That library has to be installed separately, make sure it is available on your system as a shared library.
You may need to add something to your link library search path to let the jvm pick it up.

Software license: MIT

## Example

Running the following code:
```kotlin
val b = Binaryen.INSTANCE
val module: BinaryenModuleRef = b.BinaryenModuleCreate()

// Create a function type for  i32 (i32, i32)
val params = arrayOf(b.BinaryenTypeInt32(), b.BinaryenTypeInt32()).toIntArray()
val iii: BinaryenFunctionTypeRef = b.BinaryenAddFunctionType(module, "iii", b.BinaryenTypeInt32(), params, 2);

// Get the 0 and 1 arguments, and add them
val x: BinaryenExpressionRef = b.BinaryenLocalGet(module, 0, b.BinaryenTypeInt32())
val y: BinaryenExpressionRef = b.BinaryenLocalGet(module, 1, b.BinaryenTypeInt32())
val add: BinaryenExpressionRef = b.BinaryenBinary(module, b.BinaryenAddInt32(), x, y)

// Create the add function
// Note: no additional local variables
// Note: no basic blocks here, we are an AST. The function body is just an expression node.
val adder: BinaryenFunctionRef = b.BinaryenAddFunction(module, "adder", iii, null, 0, add);

// Print it out
b.BinaryenModulePrint(module);

// Clean up the module, which owns all the objects we created above
b.BinaryenModuleDispose(module);
```

results in the following Webasm Text output:
```
(module
 (type $iii (func (param i32 i32) (result i32)))
 (func $adder (; 0 ;) (type $iii) (param $0 i32) (param $1 i32) (result i32)
  (i32.add
   (local.get $0)
   (local.get $1)
  )
 )
)
```
