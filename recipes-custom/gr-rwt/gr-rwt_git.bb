SUMMARY = "RWT blocks written based on IIO."
HOMEPAGE = "https://github.com/redwiretechnologies/gr-rwt"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"

DEPENDS ="gnuradio libiio libad9361-iio python3 cppunit libgpiod python3-pybind11-native python3-native python3-numpy-native boost"
RDEPENDS:${PN} = "gnuradio python3-click"

inherit gnuradio-oot


S="${WORKDIR}/git"

SRC_URI = "git://github.com/redwiretechnologies/gr-rwt.git;branch=removefpgaloader;protocol=https"
SRCREV = "7ed6c712070abef60f834fecc4759371f110668c"



