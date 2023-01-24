do_install() {
    install -d ${D}${libdir}/fonts/
    find ./ -name '*.tt[cf]' -exec install -m 0644 {} ${D}${libdir}/fonts/ \;
    install -d ${D}${sysconfdir}/fonts/conf.d/
    install -m 0644 ${WORKDIR}/30-dejavu-aliases.conf ${D}${sysconfdir}/fonts/conf.d/
}

FILES:${PN}-sans            = "${libdir}/fonts/DejaVuSans.ttf ${libdir}/fonts/DejaVuSans-*.ttf"
FILES:${PN}-sans-mono       = "${libdir}/fonts/DejaVuSansMono*.ttf"
FILES:${PN}-sans-condensed  = "${libdir}/fonts/DejaVuSansCondensed*.ttf"
FILES:${PN}-serif           = "${libdir}/fonts/DejaVuSerif.ttf ${libdir}/fonts/DejaVuSerif-*.ttf"
FILES:${PN}-serif-condensed = "${libdir}/fonts/DejaVuSerifCondensed*.ttf"
FILES:${PN}-mathtexgyre     = "${libdir}/fonts/DejaVuMathTeXGyre.ttf"
