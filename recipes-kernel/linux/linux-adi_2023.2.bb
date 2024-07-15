SRCREV := "75586fca4f5940bc8b7d6c2ba9dd00f0f2a48451"
KBRANCH := "main"
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

