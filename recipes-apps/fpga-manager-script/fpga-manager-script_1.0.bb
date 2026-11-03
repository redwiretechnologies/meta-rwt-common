SUMMARY = "Install user script to support fpga-manager"
DESCRIPTION = "Install user script that loads and unloads overlays using kernel fpga-manager"
LICENSE = "Proprietary"
LIC_FILES_CHKSUM = "file://${UNPACKDIR}/fpgautil.c;beginline=1;endline=27;md5=539ca56f1a6518c1f8b5de9173532686"

SRC_URI = "\
	file://fpgautil.c \
	"


FILESEXTRAPATHS:prepend := "${THISDIR}/files:"

do_compile() {
	${CC} ${LDFLAGS} ${UNPACKDIR}/fpgautil.c -o fpgautil
}

do_install() {
        install -Dm 0755 ${B}/fpgautil ${D}${bindir}/fpgautil
}

FILES:${PN} = "\
        ${bindir}/fpgautil \
        "
