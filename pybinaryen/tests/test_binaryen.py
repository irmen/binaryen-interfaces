import unittest
import binaryen


class TestBinaryen(unittest.TestCase):
    def setUp(self):
        binaryen.SetColorsEnabled(False)

    def test_minimal(self):
        module = binaryen.ModuleCreate()
        wasmt_cffi = binaryen.ModuleAllocateAndWriteText(module)
        wasmt = binaryen.ffi.string(wasmt_cffi)
        binaryen.ModuleDispose(module)
        self.assertEqual(b"(module\n)\n", wasmt)

    def test_basic(self):
        module = binaryen.ModuleCreate()
        params = [binaryen.TypeInt32(), binaryen.TypeInt32()]
        iii = binaryen.AddFunctionType(module, b"iii", binaryen.TypeInt32(), params, len(params))
        x = binaryen.LocalGet(module, 0, binaryen.TypeInt32())
        y = binaryen.LocalGet(module, 1, binaryen.TypeInt32())
        add = binaryen.Binary(module, binaryen.AddInt32(), x, y)
        adder = binaryen.AddFunction(module, b"adder", iii, binaryen.ffi.NULL, 0, add)
        binaryen.ModulePrint(module)
        binaryen.ModuleDispose(module)


if __name__ == '__main__':
    unittest.main()
