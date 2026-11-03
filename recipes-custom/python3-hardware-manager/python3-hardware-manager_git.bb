# Recipe created by recipetool
# This is the basis of a recipe and may need further editing in order to be fully functional.
# (Feel free to remove these comments when editing.)

# WARNING: the following LICENSE and LIC_FILES_CHKSUM values are best guesses - it is
# your responsibility to verify that the values are complete and correct.
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=cda32aa4f970ace97c64696c891f695e"

SRC_URI = "git://git@github.com/redwiretechnologies/hardware_manager.git;protocol=ssh;branch=main"

RDEPENDS:${PN} = "python3-fastui python3-typer python3-smbus python3-nicegui python3-ifaddr python3-markdown-it-py python3-plugin-manager"

# Modify these as desired
PV = "1.0+git"
SRCREV = "861b1ec3bd52436652778df1731b47a610f0c96b"


inherit python_setuptools_build_meta


