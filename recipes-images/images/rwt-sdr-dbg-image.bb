SUMMARY = "rwt-sdr-image plus debug symbols (-dbg packages) for on-target debugging"
DESCRIPTION = "Same contents as rwt-sdr-image with dbg-pkgs added. The debug \
symbols roughly triple the rootfs size, so this image does not fit an 8 GB card."

require recipes-images/images/rwt-sdr-image.bb

IMAGE_FEATURES += "dbg-pkgs"
