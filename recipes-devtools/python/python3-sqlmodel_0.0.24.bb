
SUMMARY = "FastAPI framework, high performance, easy to learn, fast to code, ready for production"
HOMEPAGE = "None"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=9a9a6a2d489648dbc252709d26b56738"

SRC_URI[md5sum] = "3ace12e7d9c2cdebf947aafbcd3977ff"
SRC_URI[sha256sum] = "cc5c7613c1a5533c9c7867e1aab2fd489a76c9e8a061984da11b4e613c182423"

DEPENDS = "python3-pdm-backend-native python3-pdm-native"
RDEPENDS:${PN} = "\
    python3-fastapi \
"

inherit  python_setuptools_build_meta pypi 
