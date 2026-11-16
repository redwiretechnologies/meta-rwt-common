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
