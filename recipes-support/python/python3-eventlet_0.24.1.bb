SUMMARY = "Concurrent networking library"

DESCRIPTION = "Concurrent networking library."
HOMEPAGE = "https://github.com/eventlet/eventlet"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=56472ad6de4caf50e05332a34b66e778"

SRC_URI[md5sum] = "134628cfffc403e194f2dccae8b9a39f"
SRC_URI[sha256sum] = "d9d31a3c8dbcedbcce5859a919956d934685b17323fc80e1077cb344a2ffa68d"

inherit pypi setuptools3

PYPI_PACKAGE = "eventlet"
RDEPENDS_${PN} = "${PYTHON_PN}-greenlet ${PYTHON_PN}-dnspython ${PYTHON_PN}-six ${PYTHON_PN}-monotonic"
