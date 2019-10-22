import unittest
import binaryen

class TestBinaryen(unittest.TestCase):
    def test_basic(self):
        m = binaryen.ModuleCreate()
        binaryen.ModuleOptimize(m)
        binaryen.ModuleDispose(m)


if __name__ == '__main__':
    unittest.main()
