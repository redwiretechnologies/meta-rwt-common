DESCRIPTION = "FPGA Clock Configuration Device Driver"
HOMEPAGE = "https://github.com/ikwzm/fclkcfg"
LICENSE = "BSD-3-Clause"
LIC_FILES_CHKSUM = "file://LICENSE;md5=6e83d63de93384e6cce0fd3632041d91"

inherit module

FILESEXTRAPATHS:prepend := "${THISDIR}/files:"

SRCREV = "3921015f1f98048ffb994fac17c02dc81fc2c4c6"
SRC_URI = "git://github.com/ikwzm/fclkcfg.git;protocol=https \
            "


S = "${WORKDIR}/git"
RPROVIDES_${PN} += "kernel-module-fclkcfg"
