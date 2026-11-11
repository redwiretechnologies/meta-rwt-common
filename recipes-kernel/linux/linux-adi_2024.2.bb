SRCREV := "1fa2e464ba4272471653b7b65cc3b4665bdb6665"
KBRANCH := "xlnx/release/v6.12.y-2026r1-94"
LINUX_VERSION := "6.12.94"
DEPENDS = "linux-firmware"
LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://COPYING;md5=bbea815ee2795b2f4230826c0c6b8814"

FILESEXTRAPATHS:prepend := "${THISDIR}/files:"

# This version extension should match CONFIG_LOCALVERSION in defconfig
LINUX_VERSION_EXTENSION = ""
PV = "${LINUX_VERSION}${LINUX_VERSION_EXTENSION}+git${SRCPV}"

SRC_URI += "${KERNELURI};${SRCBRANCHARG} \
           file://dt-overlay.cfg \
           ${YOCTO_META} \
           "
include linux-adi.inc

