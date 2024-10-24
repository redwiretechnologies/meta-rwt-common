SUMMARY = "files for reading board id eeproms"
HOMEPAGE = "https://github.com/redwiretechnologies"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"

SRC_URI = "git://github.com/redwiretechnologies/board_id.git;branch=master;protocol=https \
"
S = "${WORKDIR}/git"
SRCREV = "c4e4e8c0714ee56cf9416a15f7244b56bc49b8b8"
DEPENDS = "python3"
RDEPENDS:${PN} = "perl"

#SRC_URI = " file://rwt_fm_radio.grc \
#            file://adsb_rx_rwt.grc \
#            file://led_blink.py \
#"


do_install() {
       install -d ${D}${bindir}
       cp -r ${S}/board_id* ${D}${bindir}
}
FILES:${PN} +="\
        ${bindir}/board_id \
        ${bindir}/board_id.json \
        "
