import kotlin.test.*
import razorvine.kbinaryen.*

class BinaryenBasicTests {
    init {
        Binaryen.INSTANCE.BinaryenSetColorsEnabled(false)
    }

    @Test
    fun testMinimal() {
        val b = Binaryen.INSTANCE
        val module = b.BinaryenModuleCreate()
        val wasmt = b.BinaryenModuleAllocateAndWriteText(module)
        b.BinaryenModuleDispose(module)
        assertEquals("(module\n)\n", wasmt)
    }

    @Test
    fun testBasics() {
        val b = Binaryen.INSTANCE
        val module: BinaryenModuleRef = b.BinaryenModuleCreate()

        // Create a function type for  i32 (i32, i32)
        val params = b.BinaryenTypeCreate(arrayOf(b.BinaryenTypeInt32(), b.BinaryenTypeInt32()).toLongArray(), 2)
        val results = b.BinaryenTypeInt32()

        // Get the 0 and 1 arguments, and add them
        val x: BinaryenExpressionRef = b.BinaryenLocalGet(module, 0, b.BinaryenTypeInt32())
        val y: BinaryenExpressionRef = b.BinaryenLocalGet(module, 1, b.BinaryenTypeInt32())
        val add: BinaryenExpressionRef = b.BinaryenBinary(module, b.BinaryenAddInt32(), x, y)

        // Create the add function
        // Note: no additional local variables
        // Note: no basic blocks here, we are an AST. The function body is just an expression node.
        val adder: BinaryenFunctionRef = b.BinaryenAddFunction(module, "adder", params, results, null, 0, add)

        // Print it out
        b.BinaryenModulePrint(module)

        // Clean up the module, which owns all the objects we created above
        b.BinaryenModuleDispose(module)
    }
}
