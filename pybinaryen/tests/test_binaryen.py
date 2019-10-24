import unittest
import binaryen as b


class TestBinaryen(unittest.TestCase):
    def test_basic(self):
        module = b.ModuleCreate()
        params = [b.TypeInt32(), b.TypeInt32()]
        iii = b.AddFunctionType(module, b"iii", b.TypeInt32(), params, len(params))
        x = b.LocalGet(module, 0, b.TypeInt32())
        y = b.LocalGet(module, 1, b.TypeInt32())
        add = b.Binary(module, b.AddInt32(), x, y)
        adder = b.AddFunction(module, b"adder", iii, b.ffi.NULL, 0, add)
        b.ModulePrint(module)
        b.ModuleDispose(module)


if __name__ == '__main__':
    unittest.main()
