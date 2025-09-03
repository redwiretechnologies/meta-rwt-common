SUMMARY = "Miscellaneous files required to get gether running at boot."
LICENSE = "MIT"
LIC_FILES_CHKSUM = " \
file://${COMMON_LICENSE_DIR}/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302 \
"

RDEPENDS:${PN} = "systemd python3-hardware-manager"
SRC_URI = "\
    file://board_id \
    file://hardware_manager.service \
    file://fpgaloader  \
    file://fpga_info \
    "
S = "${WORKDIR}"

FILESEXTRAPATHS:prepend := "${THISDIR}/files:"

INSANE_SKIP:${PN} += "empty-dirs"

do_install() {
    install -Dm 0755 ${S}/fpga_info ${D}${bindir}/fpga_info
    install -Dm 0755 ${S}/fpgaloader ${D}${bindir}/fpgaloader
    install -Dm 0755 ${S}/board_id ${D}${bindir}/board_id
    install -Dm 0644 ${S}/hardware_manager.service ${D}${sysconfdir}/systemd/system/hardware_manager.service
}

FILES:${PN} = "\
    ${bindir}/fpga_info \
    ${bindir}/fpgaloader \
    ${bindir}/board_id \
    ${sysconfdir}/systemd/system/hardware_manager.service \
    "
