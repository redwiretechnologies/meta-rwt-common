require python3-pyadi-iio.inc
inherit pypi python_setuptools_build_meta

SRC_URI += "file://0001-adding-setup.py-so-everything-will-build.patch"
SRC_URI[md5sum] = "489e40278d81581d2e041eda7e0ec21a"
SRC_URI[sha256sum] = "4c077d3394c905e1413effb978e9437fc0f7058c1e11a084a4803c58b62415c1"
RDEPENDS:${PN} +="libiio-python3 python3-paramiko python3-pynacl python3-bcrypt"

#PIP_INSTALL_DIST_PATH = "${S}/dist"
#do_configure:prepend() {
#cat > ${S}/setup.py <<-EOF
#from setuptools import setup

#setup()
#EOF
#}
