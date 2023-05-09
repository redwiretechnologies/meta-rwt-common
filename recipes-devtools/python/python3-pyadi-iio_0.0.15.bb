require python3-pyadi-iio.inc
inherit pypi setuptools3
SRC_URI[md5sum] = "d258374fab29540e9f9ee38d36257a2e"
SRC_URI[sha256sum] = "fb6a9a47ed4af5a5c50819cf9973a93ea7148c2b70d775edb71bdf0e7da292b6"
RDEPENDS:${PN} +="libiio-python3 python3-paramiko python3-pynacl python3-bcrypt"
