SUMMARY = "IIO blocks for GNU Radio"
HOMEPAGE = "https://github.com/analogdevicesinc/gr-iio"
LICENSE = "GPLv3"
LIC_FILES_CHKSUM = "file://COPYING;md5=d32239bcb673463ab874e80d47fae504"

DEPENDS ="swig-native swig gnuradio libiio libad9361-iio python3 bison-native"

inherit setuptools3 cmake pkgconfig

export BUILD_SYS
export HOST_SYS="${MULTIMACH_TARGET_SYS}"

S="${WORKDIR}/git"

PV = "0.3.1"

#SRC_URI = "git://github.com/analogdevicesinc/gr-iio \
#           file://0001-lib64-fix-and-removing-.so-versioning.patch \
#           "
#SRCREV = "e9d12b559c3efa085304fffba4a4310bb1297367"


#SRC_URI = "git://github.com/flynn378/gr-iio;branch=gr3.8 "
SRC_URI = "git://github.com/analogdevicesinc/gr-iio;branch=upgrade-3.8 "
SRCREV = "b3bd9edfaa03e8c63631f9166e1997870cc6b9ba"

#FILESEXTRAPATHS_prepend := "${THISDIR}/gr-iio:"

#EXTRA_OECMAKE = " \
#    -DGR_PYTHON_DIR=${PYTHON_SITEPACKAGES_DIR} \
#    -DPYTHON3=1 \
#    -DENABLE_DOXYGEN=OFF \
#    "


INSANE_SKIP_${PN} = "dev-so"
#FILES_SOLIBSDEV = ""
#FILES_${PN} += " \
#    /usr/share/lib/* \
#    /usr/share/gnuradio/grc/blocks/* \
#"
FILES_SOLIBSDEV = ""
FILES_${PN} += "${datadir}/gnuradio/grc/blocks/* ${libdir}/*.so"
