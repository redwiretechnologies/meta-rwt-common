SUMMARY = "Library to manage multi-chip sync on FMCOMMS5 platforms with multiple AD9361 devices"
HOMEPAGE = "https://github.com/analogdevicesinc/libad9361-iio"
SECTION = "libs"
LICENSE = "LGPL-2.1-or-later"
LIC_FILES_CHKSUM = "file://LICENSE;md5=40d2542b8c43a3ec2b7f5da31a697b88"

# The main branch (v0.4) builds against libiio v1.0 (recipes-support/libiio/libiio_1.0.bb).
# The libad9361-iio-v0 branch only supports libiio v0.x.
BRANCH = "main"
# Pinned for reproducible builds (tip of main, 2026-11-13; same as scarthgap).
SRCREV = "7d8e7cadd07636cafb7a87d6bcdcc4dd4fcca9b3"
PV = "0.4+git"

SRC_URI = "git://github.com/analogdevicesinc/libad9361-iio.git;protocol=https;branch=${BRANCH}"

DEPENDS = "libiio"

inherit cmake pkgconfig
