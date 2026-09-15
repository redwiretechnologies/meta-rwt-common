SUMMARY = "Library for interfacing with IIO devices"
HOMEPAGE = "https://wiki.analog.com/resources/tools-software/linux-software/libiio"
SECTION = "libs"
LICENSE = "LGPL-2.1-or-later"
LIC_FILES_CHKSUM = "file://COPYING.txt;md5=7c13b3376cea0ce68d2d2da0a1b3a72c"

FILESEXTRAPATHS:prepend := "${THISDIR}/files:"
BRANCH ?= "main"
SRCREV = "${@ "182271dc4c5333c41b0a4bd6e8c8c92fd8ad1dbb" if bb.utils.to_boolean(d.getVar('BB_NO_NETWORK')) else d.getVar('AUTOREV')}"
# Just overwrite SRC_URI as we would need to delete the python bindings patch since it does not apply
# (already fixed in 0.24) and we do not want to hardcode ';branch=master' so that we would also have to
# remove that leaving the variable empty anyways.
SRC_URI = "git://github.com/analogdevicesinc/libiio.git;protocol=https;branch=${BRANCH} \
           file://syvinitscript.patch \
           "
UPSTREAM_CHECK_GITTAGREGEX = "v(?P<pver>\d+(\.\d+)+)"

S = "${WORKDIR}/git"
PV = "1.0+git${SRCPV}"


DEPENDS = " \
    flex-native bison-native libaio \
"

inherit cmake python3native systemd update-rc.d pkgconfig

EXTRA_OECMAKE += " \
	${@bb.utils.contains('DISTRO_FEATURES', 'sysvinit', '-DWITH_SYSVINIT=on', '', d)} \
	-DCPP_BINDINGS=ON \
	-DFLEX_TARGET_ARG_COMPILE_FLAGS='--noline' \
	-DBISON_TARGET_ARG_COMPILE_FLAGS='--no-lines' \
	-DPYTHON_BINDINGS=OFF \
 	-DWITH_IIOD_USB_DMABUF=ON \
 	-DLOG_LEVEL=Error \
 	-DUDEV_RULES_INSTALL_DIR=${nonarch_base_libdir}/udev/rules.d \
 	${@bb.utils.contains('DISTRO_FEATURES', 'systemd', '-DWITH_SYSTEMD=ON -DSYSTEMD_UNIT_INSTALL_DIR=${systemd_system_unitdir}', '', d)} \
"
INITSCRIPT_NAME = "${@bb.utils.contains('DISTRO_FEATURES', 'sysvinit', 'iiod', '', d)}"

PACKAGECONFIG ??= " \
    usb_backend network_backend serial_backend xml_backend hwmon \
    ${@bb.utils.contains('DISTRO_FEATURES', 'zeroconf', 'dnssd', '', d)} \
"

# network_backend, serial_backend and usb_backend depend on xml_backend, so don't switch it off
XML_BACKEND_DISABLE = "${@bb.utils.contains_any('PACKAGECONFIG', 'network_backend serial_backend usb_backend', '', '-DWITH_XML_BACKEND=off', d)}"

PACKAGECONFIG[usb_backend] = "-DWITH_USB_BACKEND=ON -DWITH_XML_BACKEND=ON,-DWITH_USB_BACKEND=OFF,libusb1 libxml2"
PACKAGECONFIG[network_backend] = "-DWITH_NETWORK_BACKEND=ON -DWITH_XML_BACKEND=ON,-DWITH_NETWORK_BACKEND=OFF,libxml2"
PACKAGECONFIG[serial_backend] = "-DWITH_SERIAL_BACKEND=ON -DWITH_XML_BACKEND=ON,-DWITH_SERIAL_BACKEND=off,libserialport libxml2"
PACKAGECONFIG[xml_backend] = "-DWITH_XML_BACKEND=ON,${XML_BACKEND_DISABLE},libxml2"
PACKAGECONFIG[dnssd] = "-DHAVE_DNS_SD=ON,-DHAVE_DNS_SD=off,avahi"
PACKAGECONFIG[hwmon] = "-DWITH_HWMON=ON,-DWITH_HWMON=OFF"

PACKAGES =+ "${PN}-iiod ${PN}-tests "


FILES:${PN}-iiod = " \
    ${sbindir}/iiod \
    ${systemd_system_unitdir}/iiod.service \
"
FILES:${PN}-tests = "${bindir}"


SYSTEMD_PACKAGES = "${PN}-iiod"
SYSTEMD_SERVICE:${PN}-iiod = "iiod.service"

# Explicitly define do_configure, do_compile and do_install because both cmake and setuptools3 have
# EXPORT_FUNCTIONS do_configure do_compile do_install
do_configure() {
    cmake_do_configure
}

do_compile() {

    cmake_do_compile
}

do_install() {

    cmake_do_install
}
