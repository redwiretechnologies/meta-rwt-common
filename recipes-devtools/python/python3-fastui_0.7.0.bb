
SUMMARY = "FastAPI framework, high performance, easy to learn, fast to code, ready for production"
HOMEPAGE = "None"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=419226819d2dd980a61db3d34a9d2486"

SRC_URI[md5sum] = "bfc873f6ec7ab9cd406822793168ee7e"
SRC_URI[sha256sum] = "08ec1b8437653fc37caaf3dae46566a43dbda3f190c62c43f8f3d063261dd1e8"

DEPENDS = "python3-hatchling-native"
RDEPENDS:${PN} = "\
    python3-pydantic \
"

inherit  python_setuptools_build_meta pypi 
