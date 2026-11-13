PACKAGECONFIG[iio] = "-DENABLE_GR_IIO=ON,-DENABLE_GR_IIO=OFF,libiio libad9361-iio "

PACKAGECONFIG:append = " iio"

GR_PACKAGES:append = " gnuradio-iio"
FILES:${PN}-iio = "${PYTHON_SITEPACKAGES_DIR}/gnuradio/iio \
+                   ${datadir}/gnuradio/iio"

FILESEXTRAPATHS:prepend := "${THISDIR}/${PN}:"

SRC_URI += "file://0001-supporting-libiio_v1.patch"

