SUMMARY = " Python Bindings Library for interfacing with IIO devices"
HOMEPAGE = "https://wiki.analog.com/resources/tools-software/linux-software/libiio"
SECTION = "libs"
LICENSE = "LGPL-2.1-or-later"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/LGPL-2.1-or-later;md5=2a4f4fd2128ea2f65047ee63fbca9f68"
BRANCH ?= "main"
RDEPENDS:${PN} += "libiio"

SRC_URI = "git://github.com/analogdevicesinc/libiio.git;protocol=https;branch=${BRANCH} "
SRCREV = "01cc5927664939ded51cc3b91b972d80c7c231a0"

RDEPENDS:${PN} = "python3-fastui python3-typer python3-smbus python3-nicegui python3-ifaddr"

S = "${WORKDIR}/git/bindings/python"
PV = "1.0+git${SRCPV}"
# Modify these as desired




inherit python_setuptools_build_meta
