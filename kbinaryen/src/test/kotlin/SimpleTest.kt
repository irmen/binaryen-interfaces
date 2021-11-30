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
        MainTest.run()
    }
}
