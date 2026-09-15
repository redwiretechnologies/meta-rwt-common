# Recipe created by recipetool
# This is the basis of a recipe and may need further editing in order to be fully functional.
# (Feel free to remove these comments when editing.)

# WARNING: the following LICENSE and LIC_FILES_CHKSUM values are best guesses - it is
# your responsibility to verify that the values are complete and correct.
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=cda32aa4f970ace97c64696c891f695e"

SRC_URI = "git://git@github.com/redwiretechnologies/hardware_manager.git;protocol=ssh;branch=main"

RDEPENDS:${PN} = "python3-fastui python3-typer python3-smbus python3-nicegui python3-ifaddr"

# Modify these as desired
PV = "1.0+git"
SRCREV = "88e2cd73645f2c32678fb2178d7aa94a81e12cde"

S = "${WORKDIR}/git"
inherit python_setuptools_build_meta


