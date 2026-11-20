SUMMARY = "RWT blocks written based on IIO."
HOMEPAGE = "https://github.com/redwiretechnologies/gr-rwt"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"

DEPENDS = "gnuradio libiio libad9361-iio python3 cppunit libgpiod python3-pybind11-native python3-native python3-numpy-native boost"
RDEPENDS:${PN} = "gnuradio python3-click"

inherit gnuradio-oot


SRC_URI = "git://github.com/redwiretechnologies/gr-rwt.git;branch=libiio-v1-upgrade;protocol=https"
SRCREV = "9f9011e4fefb28ccf0a5877973763a68c3618794"



# gr-rwt's CMake exports absolute recipe-sysroot paths (libiio.so, libad9361.so, ...)
# in INTERFACE_LINK_LIBRARIES, which fails the buildpaths QA check. Make them
# relative to CMAKE_SYSROOT (empty on target, the SDK sysroot when cross-compiling).
do_install:append() {
    sed -i -e "s#${RECIPE_SYSROOT}#\${CMAKE_SYSROOT}#g" ${D}${libdir}/cmake/rwt/*.cmake
}
