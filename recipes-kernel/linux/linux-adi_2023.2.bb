#SRCREV := "e9288a95089184ad0938c763ac6fc4348bc697dd"
SRCREV := "e2e62cc28c80b24e062fcf1da22ebe4908d6bc61"
KBRANCH := "2023_R2"
LINUX_VERSION := "6.1.70"
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
           file://usbmods.cfg \
           file://moreusb.cfg \
           file://sensors.cfg \
           file://random.cfg \
           file://pci_usb3380.cfg \
           file://power.cfg \
           "
include linux-adi.inc

