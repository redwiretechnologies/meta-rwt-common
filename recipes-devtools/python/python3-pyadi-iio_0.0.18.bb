require python3-pyadi-iio.inc
inherit pypi python_setuptools_build_meta

SRC_URI += "file://0001-adding-setup.py-so-everything-will-build.patch"
RDEPENDS:${PN} +="libiio-python3 python3-paramiko python3-pynacl python3-bcrypt"
PYPI_PACKAGE = "pyadi_iio"
SRC_URI[sha256sum] = "bb43877b6de1068b35b05799005203b41e250e33c87ddbf84c06ac0af8f9a1e5"

#PIP_INSTALL_DIST_PATH = "${S}/dist"
#do_configure:prepend() {
#cat > ${S}/setup.py <<-EOF
#from setuptools import setup

#setup()
#EOF
#}
