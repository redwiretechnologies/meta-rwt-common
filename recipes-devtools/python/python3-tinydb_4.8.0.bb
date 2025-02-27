DESCRIPTION = "Small python database"
HOMEPAGE = "https://tinydb.readthedocs.io/en/latest/"
SECTION = "devel/python"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=ee9d91e0565d932659cf275d126c7437"

SRC_URI[md5sum] = "8738999976febfe7e8ea81c4b1910f9b"
SRC_URI[sha256sum] = "6dd686a9c5a75dfa9280088fd79a419aefe19cd7f4bd85eba203540ef856d564"

PYPI_PACKAGE = "tinydb"
inherit pypi python_poetry_core
RDEPENDS:${PN} += "python3-core python3-six python3-debugger"
