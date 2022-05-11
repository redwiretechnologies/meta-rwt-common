SUMMARY = "RWT blocks written based on IIO."
HOMEPAGE = "https://github.com/redwiretechnologies/gr-rwt"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"

DEPENDS ="swig-native swig gnuradio libiio libad9361-iio python3 cppunit libgpiod python3-pybind11-native"
RDEPENDS_${PN} = "gnuradio python3-click"

inherit setuptools3 cmake pkgconfig

export BUILD_SYS
export HOST_SYS="${MULTIMACH_TARGET_SYS}"

S="${WORKDIR}/git"

SRC_URI = "git://github.com/redwiretechnologies/gr-rwt.git;branch=maint-3.10;protocol=https"
SRCREV = "551e320e031ff826bc5af4cc5809c9c6433b8991"


EXTRA_OECMAKE = " \
    -DGR_PYTHON_DIR=${PYTHON_SITEPACKAGES_DIR} \
    -DPYTHON3=1 \
    -DENABLE_DOXYGEN=OFF \
    "

INSANE_SKIP_${PN} = "dev-so"
FILES_SOLIBSDEV = ""
FILES_${PN} += " \
    ${datadir}/gnuradio/grc/blocks/*.yml \
    ${libdir}/*.so \
"
