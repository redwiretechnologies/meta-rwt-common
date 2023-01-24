DESCRIPTION = "Small python database"
HOMEPAGE = "https://tinydb.readthedocs.io/en/latest/"
SECTION = "devel/python"
LICENSE = "open"
LIC_FILES_CHKSUM = "file://LICENSE;md5=ee9d91e0565d932659cf275d126c7437"

SRC_URI[md5sum] = "c8a11437354c86786801d871d848a7e4"
SRC_URI[sha256sum] = "357eb7383dee6915f17b00596ec6dd2a890f3117bf52be28a4c516aeee581100"

PYPI_PACKAGE = "tinydb"
inherit pypi setuptools3
RDEPENDS:${PN} += "python3-core python3-six python3-debugger"
