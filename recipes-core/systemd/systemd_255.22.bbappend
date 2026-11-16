# meta-xilinx-core backports this patch for all systemd versions, but it is
# already part of systemd v255.22 (poky scarthgap), so it fails in do_patch.
SRC_URI:remove = "file://0001-socket-downgrade-not-supported-logging-for-SO_PASSSE.patch"
