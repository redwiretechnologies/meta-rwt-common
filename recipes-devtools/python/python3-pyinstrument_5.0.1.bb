SUMMARY = "Fast, correct Python JSON library supporting dataclasses, datetimes, and numpy"
HOMEPAGE = "https://pypi.org/project/pyinstrument/"
LICENSE = "BSD-3-Clause"
LIC_FILES_CHKSUM = "file://LICENSE;md5=e0510e6ecbcdcb87e3cf13147f37f166"

DEPENDS += "python3-maturin-native"

PYPI_PACKAGE = "pyinstrument"

SRC_URI[sha256sum] = "f4fd0754d02959c113a4b1ebed02f4627b6e2c138719ddf43244fd95f201c8c9"



inherit  pypi python_pyo3 python_setuptools_build_meta


