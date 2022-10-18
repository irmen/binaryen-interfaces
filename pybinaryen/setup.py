import re
import os
import sys
import unittest
from setuptools import setup

modules_path = os.path.abspath(".")  # to make sure the compiler can find the required include files
PKG_VERSION = re.search(r'^__version__\s*=\s*"(.+)"', open("binaryen.py", "rt").read(), re.MULTILINE).groups()[0]


def test_suite():
    testloader = unittest.TestLoader()
    testsuite = testloader.discover("tests", pattern="test*.py")
    return testsuite


if __name__ == "__main__":
    setup(
        name="pybinaryen",
        version=PKG_VERSION,
        include_dirs=[modules_path],
        zip_safe=False,
        include_package_data=False,
        py_modules=["binaryen"],
        install_requires=["cffi>=1.3.0"],
        setup_requires=["cffi>=1.3.0"],
        tests_require=[],
        test_suite="setup.test_suite"
    )
