require linux-microblaze.inc

# Add meta-xilinx kmeta
FILESEXTRAPATHS:prepend := "${THISDIR}:"
SRC_URI:append = " file://adi-kmeta;type=kmeta;name=adi-kmeta;destsuffix=adi-kmeta"

# Zynq default generic KMACHINE
COMPATIBLE_MACHINE:zynq = "zynq"
KMACHINE:zynq = "zynq"

# ZynqMP default generic KMACHINE
COMPATIBLE_MACHINE:zynqmp = "zynqmp"
KMACHINE:zynqmp = "zynqmp"

# MicroBlaze KMACHINEs
KMACHINE:ml605-qemu-microblazeel = "qemumicroblazeel"
KMACHINE:s3adsp1800-qemu-microblazeeb = "qemumicroblazeeb"

# MicroBlaze default generic KMACHINE
KMACHINE:microblaze = "microblaze"
COMPATIBLE_MACHINE:microblaze = "microblaze"

# Default kernel config fragements for specific machines
KERNEL_FEATURES:append:kc705-microblazeel = " bsp/kc705-microblazeel/kc705-microblazeel.scc"

