SRCREV := "793a33896ceb503ddb56e4f07a4e5887496793ff"
KBRANCH := "xlnx/release/v6.12.y-2026r1"
LINUX_VERSION := "6.12.77"
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

