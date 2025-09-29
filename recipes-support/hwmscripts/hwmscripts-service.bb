SUMMARY = "Miscellaneous files required to get gether running at boot."
LICENSE = "MIT"
LIC_FILES_CHKSUM = " \
file://${COMMON_LICENSE_DIR}/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302 \
"

inherit systemd

RDEPENDS:${PN} = "systemd python3-hardware-manager"
SRC_URI = "\
    file://hardware_manager.service \
    "
S = "${WORKDIR}"

SYSTEMD_AUTO_ENABLE:${PN} = "enable"
SYSTEMD_PACKAGES = "${PN}"

SYSTEMD_SERVICE:${PN} = "hardware_manager.service"

FILESEXTRAPATHS:prepend := "${THISDIR}/files:"

INSANE_SKIP:${PN} += "empty-dirs"

do_install() {



    install -Dm 0644 ${S}/hardware_manager.service ${D}${systemd_system_unitdir}/hardware_manager.service
}

FILES:${PN} = "\
    $${systemd_system_unitdir}/hardware_manager.service \
    "
