SUMMARY = "GNU Radio 4 source and sink blocks for the RWT Oxygen SDR"
DESCRIPTION = "Out-of-tree GNU Radio 4 module with RWTSource, RWTDualSource, \
RWTSink and RWTDualSink: the blocks of gr-rwt, for GR4, on libiio v1. \
Local mode runs on the Oxygen with the 'default' FPGA personality \
(timestamps, PPS, timed TX bursts); remote mode reaches an Oxygen \
running the 'griio' personality over the network."
HOMEPAGE = "https://github.com/redwiretechnologies/gr-rwt"
SECTION = "libs"
# gr4-rwt is dual licensed: the terms of the Apache License 2.0 when used with Red Wire Technologies
# hardware (LICENSE.RWT-Hardware), GPL-3.0-or-later otherwise. The ptest package also ships libiio's
# fmcomms2.xml test description (GPL-2.0-or-later, libiio's license for its tests).
# RWT-Hardware-Apache-2.0 is LicenseRef-RWT-Hardware-Apache-2.0 in gr4-rwt's SPDX headers. The & / | syntax is the
# one wrynose and older take; master reads it too (with a note to use SPDX AND / OR).
LICENSE = "(RWT-Hardware-Apache-2.0 | GPL-3.0-or-later) & GPL-2.0-or-later"
LICENSE:${PN} = "RWT-Hardware-Apache-2.0 | GPL-3.0-or-later"
LICENSE:${PN}-dev = "RWT-Hardware-Apache-2.0 | GPL-3.0-or-later"
LICENSE:${PN}-dbg = "RWT-Hardware-Apache-2.0 | GPL-3.0-or-later"
LICENSE:${PN}-staticdev = "RWT-Hardware-Apache-2.0 | GPL-3.0-or-later"
LICENSE:${PN}-ptest = "(RWT-Hardware-Apache-2.0 | GPL-3.0-or-later) & GPL-2.0-or-later"
NO_GENERIC_LICENSE[RWT-Hardware-Apache-2.0] = "LICENSE.RWT-Hardware"
LIC_FILES_CHKSUM = "file://LICENSE;md5=28055fe5236bf077a0be3b510bcc9d27 \
                    file://LICENSE.RWT-Hardware;md5=52616a182271cf5467d27fde0f01e2ac \
                    file://LICENSE.Apache-2.0;md5=89aea4e17d99a7cacdbeed46a0096b10 \
                    file://LICENSE.GPL-3.0;md5=1c76c4cc354acaac30ed4d5eefea7245 \
                    file://blocks/rwt/test/data/fmcomms2.xml.license;md5=d911efe847fcdcd03ecd73100bfec778 \
                    file://${COMMON_LICENSE_DIR}/GPL-2.0-or-later;md5=fed54355545ffd980b814dab4a3b312c"


# gr4-rwt has no public repository yet. Point GR4_RWT_GIT_URI at the one
# you push it to, e.g. in local.conf or a bbappend:
#   GR4_RWT_GIT_URI = "git://git.example.com/sdr/gr4-rwt.git;protocol=https;branch=master"
#   SRCREV:pn-gr4-rwt = "<commit>"
# or build a local checkout with:  devtool modify gr4-rwt <path>
GR4_RWT_GIT_URI ?= "git://git@github.com/redwiretechnologies/gr4-rwt.git;protocol=ssh;branch=main"

SRC_URI = "${GR4_RWT_GIT_URI} \
           file://run-ptest \
           "

PV = "0.5.0+git"
SRCREV ?= "5ce96f4faf4113415c8227afb2944fee400dd8be"

inherit cmake pkgconfig ptest

# Recipe names of libiio v1 and libad9361 (its libiio v1 port). Change them
# if your layer calls them something else.
GR4_RWT_LIBIIO ?= "libiio"
GR4_RWT_LIBAD9361 ?= "libad9361-iio"

# The tests include gnuradio4-blocks' testing headers (TagMonitors.hpp),
# shipped in gnuradio4-blocks-dev.
DEPENDS = "gnuradio4-core gnuradio4-blocks boost-ext-ut cpp-httplib ${GR4_RWT_LIBIIO}"

# ad9361: AD9361 FIR loading through libad9361, needed for AD9361 rates
# below 2.083 MS/s (remote mode, and local mode between 600 kS/s and
# 2.083 MS/s). ON fails the configure step if the libad9361 found is built
# on libiio 0.x. Without it, local-mode RX uses the FPGA CIC decimator
# below 2.083 MS/s.
PACKAGECONFIG ??= "ad9361"
PACKAGECONFIG[ad9361] = "-DENABLE_LIBAD9361=ON,-DENABLE_LIBAD9361=OFF,${GR4_RWT_LIBAD9361}"

# The tests are built by the normal do_compile (as in meta-sdr's recipes),
# with the paths they open set to where do_install_ptest puts their files
# on the target. qa_Example runs the shipped example graph with core's
# rungraph from ${bindir}.
EXTRA_OECMAKE = "\
    -DENABLE_TESTING=ON \
    -DWARNINGS_AS_ERRORS=OFF \
    -DGR4_RWT_TEST_DATA_DIR=${PTEST_PATH}/data \
    -DGR4_RWT_TEST_EXAMPLE_FILE=${PTEST_PATH}/examples/oxygen_repeater.grc \
    -DGR4_RWT_TEST_PLUGIN_DIR=${libdir}/gnuradio-4/plugins \
    -DGR4_RUNGRAPH=${bindir}/rungraph \
"
# as gnuradio4-core: silence GCC's ABI-change notes for std::complex/SIMD arguments
CXXFLAGS += " -Wno-psabi"

# The block library is a runtime-loaded GR4 plugin without a versioned
# SONAME in GR4's plugin directory, like gnuradio4-blocks' libraries.
FILES:${PN} += "${libdir}/gnuradio-4/plugins/*Shared.so"
FILES:${PN}-staticdev += "${libdir}/gnuradio-4/plugins/*Static.a"
FILES:${PN}-dev += "${libdir}/cmake/gr4_rwt"

# Blocks are header-only templates: building against them needs GR4's and
# libiio's headers too.
RDEPENDS:${PN}-dev += "gnuradio4-core-dev ${GR4_RWT_LIBIIO}-dev python3-hardware-manager"

# The block-registration generator writes the absolute source path into the
# .cpp files it generates; they end up in -src only.
INSANE_SKIP:${PN}-src += "buildpaths"

# qa_Example runs rungraph (gnuradio4-core). The emulator tests need libiio
# built with its emu backend (WITH_EMU_BACKEND=ON, libxml2) and skip
# themselves otherwise.
RDEPENDS:${PN}-ptest += "gnuradio4-core"

do_install_ptest() {
    install -d ${D}${PTEST_PATH}/tests ${D}${PTEST_PATH}/data ${D}${PTEST_PATH}/examples
    for t in ${B}/blocks/rwt/test/qa_*; do
        [ -x "$t" ] || continue
        install -m 0755 ${t} ${D}${PTEST_PATH}/tests/
    done
    install -m 0644 ${S}/blocks/rwt/test/data/fmcomms2.xml ${D}${PTEST_PATH}/data/
    install -m 0644 ${S}/examples/oxygen_repeater.grc ${D}${PTEST_PATH}/examples/
    sed -i -e 's#@LIBDIR@#${libdir}#g' ${D}${PTEST_PATH}/run-ptest
}
