PACKAGECONFIG[iio] = "-DENABLE_GR_IIO=ON,-DENABLE_GR_IIO=OFF,libiio libad9361-iio "

PACKAGECONFIG:append = " iio"

GR_PACKAGES:append = " gnuradio-iio"
FILES:${PN}-iio = "${PYTHON_SITEPACKAGES_DIR}/gnuradio/iio \
                   ${datadir}/gnuradio/iio"

FILESEXTRAPATHS:prepend := "${THISDIR}/${PN}:"

SRC_URI += "file://0001-supporting-libiio_v1.patch"


# meta-sdr (walnascar) tracks gnuradio main (3.11 development), whose CMake
# installer rework stops GR_LIBRARY_FOO from installing out-of-tree module
# libraries (gr-rwt etc.). Pin to the 3.10 maintenance branch instead.
GIT_BRANCH = "maint-3.10"
SRCREV = "d5ce5ccb7b75069c046f8dbaa16c4451452d0b19"

# meta-sdr's fosphor/OpenGL ES patch targets gnuradio main (Qt6); the
# maint-3.10 branch pinned above has no such code, so the patch cannot apply.
SRC_URI:remove = "file://0001-gr-qtgui-Don-t-build-the-fosphor-display-against-Ope.patch"

# maint-3.10 gr-qtgui is Qt5-only; meta-sdr now only offers a Qt6 "qtgui"
# option (for gnuradio main). Restore the Qt5 option using meta-qt5.
PACKAGECONFIG[qtgui5] = "-DENABLE_GR_QTGUI=ON,-DENABLE_GR_QTGUI=OFF,qtbase qwt-qt5 python3-pyqt5,python3-pyqt5"
inherit ${@bb.utils.contains('PACKAGECONFIG', 'qtgui5', 'cmake_qt5', '', d)}
GR_PACKAGES += "${@bb.utils.contains('PACKAGECONFIG', 'qtgui5', 'gnuradio-qtgui', '', d)}"
RDEPENDS:${PN}-qtgui:remove = "python3-pyqt6"

# gnuradio-runtime bakes the full cross-compiler path and CFLAGS into
# compiler_flags() (constants.cc), which trips the buildpaths QA check.
# The string is informational only (gnuradio-config-info --cflags).
do_configure:append() {
    sed -i -e 's#${TMPDIR}#<TMPDIR>#g' ${B}/gnuradio-runtime/lib/constants.cc
}
