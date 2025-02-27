
SUMMARY = "The little ASGI library that shines."
HOMEPAGE = "None"
AUTHOR = "None <Tom Christie <tom@tomchristie.com>>"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE.md;md5=11e8c8dbfd5fa373c703de492140ff7a"

SRC_URI[sha256sum] = "b35acedae74e95967dd9c0a47b45f5803dcd8973d0d95c18c1abb184845ba42c"

DEPENDS += "python3-poetry-core python3-hatchling"
RDEPENDS:${PN} += "python3-anyio"


inherit pypi python_hatchling

BBCLASSEXTEND = "native"
RDEPENDS:${PN}_class-native = ""

