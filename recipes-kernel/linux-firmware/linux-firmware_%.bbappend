FILESEXTRAPATHS:prepend := "${THISDIR}/files:"

SRC_URI:append = " \
    file://ad9467_intbypass_ad9517.stp \
    file://ad9517.stp \
    file://ad9517_fmcomms6.stp \
    file://adau1761.bin \
    file://imageon_edid.bin \
    file://pzsdr-fmc-ad9517.stp \
    file://Mykonos_M3.bin \
"

SRC_URI[ad9467_intbypass_ad9517.stp.md5sum]="4d4e72b52f0cf5cd61186d5055d785c0"

do_install:append() {
    install -d ${D}/lib/firmware/
    install -m 0755 ${WORKDIR}/ad9467_intbypass_ad9517.stp \
                    ${WORKDIR}/ad9517.stp \
                    ${WORKDIR}/ad9517_fmcomms6.stp \
                    ${WORKDIR}/adau1761.bin \
                    ${WORKDIR}/imageon_edid.bin \
                    ${WORKDIR}/Mykonos_M3.bin \
                    ${WORKDIR}/pzsdr-fmc-ad9517.stp \
                    ${D}/lib/firmware/
}

PACKAGE_ARCH = "${MACHINE_ARCH}"
