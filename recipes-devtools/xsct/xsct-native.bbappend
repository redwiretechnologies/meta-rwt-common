# XSCT's bin/ldlibpath.sh only knows Ubuntu 18/20/22/24. On newer Ubuntu hosts
# (e.g. 26.04) it adds no versioned lib dir, so the bundled libncurses.so.5 is
# not found and hsi fails with "libncurses.so.5: cannot open shared object file".
# Treat any newer Ubuntu like 24.
do_compile:append() {
    if [ "${USE_XSCT_TARBALL}" = "1" ] && [ -f ${PV}/bin/ldlibpath.sh ]; then
        sed -i 's/^\(\s*\)24\*) distrover=24 ;;/&\n\12[5-9]*|[3-9][0-9]*) distrover=24 ;;/' ${PV}/bin/ldlibpath.sh
        grep -q 'distrover=24 ;;' ${PV}/bin/ldlibpath.sh
    fi
}
