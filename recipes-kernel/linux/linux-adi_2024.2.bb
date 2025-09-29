SRCREV := "d3e1485f7f8a033b3393c3f89874b079cafcda15"
KBRANCH := "main"
LINUX_VERSION := "6.6.0"
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

