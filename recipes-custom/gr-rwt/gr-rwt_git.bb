SUMMARY = "RWT blocks written based on IIO."
HOMEPAGE = "https://github.com/redwiretechnologies/gr-rwt"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"

DEPENDS ="gnuradio libiio libad9361-iio python3 cppunit libgpiod python3-pybind11-native python3-native python3-numpy-native boost"
RDEPENDS:${PN} = "gnuradio python3-click"

inherit setuptools3 cmake pkgconfig

export BUILD_SYS
export HOST_SYS="${MULTIMACH_TARGET_SYS}"

S="${WORKDIR}/git"

SRC_URI = "git://github.com/redwiretechnologies/gr-rwt.git;branch=maint-3.10;protocol=https"
SRCREV = "e7cdf2deec00002316f8b2b1d1c36c8f42e8e06a"


EXTRA_OECMAKE = " \
    -DGR_PYTHON_DIR=${PYTHON_SITEPACKAGES_DIR} \
    -DPYTHON3=1 \
    -DENABLE_DOXYGEN=OFF \
    "

INSANE_SKIP:${PN} = "dev-so"
FILES_SOLIBSDEV = ""
FILES:${PN} += " \
    ${datadir}/gnuradio/grc/blocks/*.yml \
    ${libdir}/*.so \
"
