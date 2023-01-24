DESCRIPTION = "FPGA Clock Configuration Device Driver"
HOMEPAGE = "https://github.com/ikwzm/fclkcfg"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://LICENSE;md5=6e83d63de93384e6cce0fd3632041d91"

inherit module

FILESEXTRAPATHS:prepend := "${THISDIR}/files:"

SRCREV = "8a6fa423754941779fc01222bf710080adea8e17"
SRC_URI = "git://github.com/ikwzm/fclkcfg.git;protocol=https \
           file://0001-yocto-makefile-correction.patch \
            "


S = "${WORKDIR}/git"
RPROVIDES_${PN} += "kernel-module-fclkcfg"
