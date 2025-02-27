
SUMMARY = "FastAPI framework, high performance, easy to learn, fast to code, ready for production"
HOMEPAGE = "None"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=95792ff3fe8e11aa49ceb247e66e4810"

SRC_URI[md5sum] = "38428aff025530f61cd5b10efd764229"
SRC_URI[sha256sum] = "0ce9111231720190473e222cdf0f07f7206ad7e53ea02beb1d2dc36e2f0741e9"

DEPENDS = "python3-pdm-backend-native python3-pdm-native"
RDEPENDS:${PN} = "\
    python3-starlette \
    python3-pydantic \
    python3-typing-extensions \
    python3-uvicorn \
"

inherit  python_setuptools_build_meta pypi 
