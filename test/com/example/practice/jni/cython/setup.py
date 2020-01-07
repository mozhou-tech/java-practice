from distutils.core import setup
from Cython.Build import cythonize
from Cython.Distutils import Extension

ext_modules = [Extension("main", ["main.pyx", "main.c"])]
setup(
    ext_modules=cythonize("main.pyx")
)

#  python setup.py build_ext --inplace
