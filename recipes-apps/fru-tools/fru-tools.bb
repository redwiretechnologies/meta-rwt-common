SUMMARY = "ADI fru-tools"
SECTION = "tools"
LICENSE = "GPL-2.0-only"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/GPL-2.0-only;md5=801f80980d171dd6425610833a22dbe6"

SRCREV = "748e187277863ccd73d79c1fbe30064266fe71a4"
PV = "0.8.1.5+git${SRCPV}"
SRC_URI = "git://github.com/analogdevicesinc/fru_tools.git;branch=main;protocol=https"
S = "${WORKDIR}/git"

INSANE_SKIP:${PN} = "ldflags"

do_compile() {
        oe_runmake
}

do_install() {
    install -d ${D}${bindir}
    install -m 0755 ${S}/fru-dump ${D}${bindir}
}
