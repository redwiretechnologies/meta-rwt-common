
SUMMARY = "FastAPI framework, high performance, easy to learn, fast to code, ready for production"
HOMEPAGE = "None"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=dbc3e3da2b6b1b24fcf4e94e809c1257"

SRC_URI[md5sum] = "3d23ee03675a48e6b35e60b5074d3325"
SRC_URI[sha256sum] = "9628d76a4a5e7a88629eda6bca9f9baae10a37d8b94c63d99e1af94bb5bc9c05"

DEPENDS = "python3-pdm-backend-native python3-pdm-native python3-poetry-core-native"
RDEPENDS:${PN} = "\
    python3-fastapi \
    python3-pydantic \
    python3-typing-extensions \
    python3-uvicorn \
"

inherit  python_setuptools_build_meta pypi 
