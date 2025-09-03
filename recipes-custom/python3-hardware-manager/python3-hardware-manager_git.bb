# Recipe created by recipetool
# This is the basis of a recipe and may need further editing in order to be fully functional.
# (Feel free to remove these comments when editing.)

# WARNING: the following LICENSE and LIC_FILES_CHKSUM values are best guesses - it is
# your responsibility to verify that the values are complete and correct.
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=cda32aa4f970ace97c64696c891f695e"

SRC_URI = "git://git@github.com/redwiretechnologies/hardware_manager.git;protocol=ssh;branch=main"

# Modify these as desired
PV = "1.0+git"
SRCREV = "0a18bae4a7c735473a6b9b64e4339382e30032cf"

S = "${WORKDIR}/git"
inherit python_setuptools_build_meta


