# Fix building lsfd against glibc >= 2.43 (bsearch is a macro there).
# meta-xilinx-core carries util-linux 2.40.4; drop this when it moves on.
FILESEXTRAPATHS:prepend := "${THISDIR}/util-linux:"
SRC_URI += "file://0001-lsfd-parenthesize-compound-literal-in-bsearch-call.patch"
