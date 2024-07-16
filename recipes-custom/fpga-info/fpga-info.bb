SUMMARY = "files for reading board fpga comiled information"
HOMEPAGE = "https://github.com/redwiretechnologies.fpga_info"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"

SRC_URI = "git://github.com/redwiretechnologies/fpga_info.git;branch=master;protocol=https \
"
S = "${WORKDIR}/git"
SRCREV = "fe9655de8881fe5b6a366ed0d71ce4b6a60d4985"
CLEANBROKEN="1"

do_compile() {
        ${CXX} ${BUILD_CXXFLAGS} fpga_info.cpp ${LDFLAGS} -o fpga_info
}

do_install() {
  install -Dm 0755 ${WORKDIR}/git/fpga_info ${D}${bindir}/fpga_info
}


FILES:${PN} = "${bindir}/fpga_info"
