SRCREV := "07722d5b23d6ff0d5c75c28d9d96d1a23cabd969"
KBRANCH := "master"
LINUX_VERSION := "5.10"
DEPENDS = "linux-firmware"
LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://COPYING;md5=bbea815ee2795b2f4230826c0c6b8814"

FILESEXTRAPATHS:prepend := "${THISDIR}/files:"

# This version extension should match CONFIG_LOCALVERSION in defconfig
LINUX_VERSION_EXTENSION = ""
PV = "${LINUX_VERSION}${LINUX_VERSION_EXTENSION}+git${SRCPV}"

SRC_URI += "${KERNELURI};${SRCBRANCHARG} \
           file://dt-overlay.cfg \
           file://usbmods.cfg \
"
include linux-adi.inc

