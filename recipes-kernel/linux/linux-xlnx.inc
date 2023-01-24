# This version extension should match CONFIG_LOCALVERSION in defconfig
XILINX_RELEASE_VERSION ?= ""
LINUX_VERSION_EXTENSION ?= "-xilinx-${XILINX_RELEASE_VERSION}"
PV = "${LINUX_VERSION}${LINUX_VERSION_EXTENSION}+git${SRCPV}"

# Sources, by default allow for the use of SRCREV pointing to orphaned tags/commits
KBRANCH ?= ""
SRCBRANCHARG = "${@['nobranch=1', 'branch=${KBRANCH}'][d.getVar('KBRANCH', True) != '']}"

FILESOVERRIDES:append = ":${XILINX_RELEASE_VERSION}"
KERNELURI ?= "git://github.com/analogdevicesinc/linux.git;protocol=https"
SRC_URI = "${KERNELURI};${SRCBRANCHARG}"

SRCREV_machine ?= "${SRCREV}"

require recipes-kernel/linux/linux-yocto.inc
require linux-microblaze.inc

DESCRIPTION = "Xilinx Kernel"
LIC_FILES_CHKSUM = "file://COPYING;md5=bbea815ee2795b2f4230826c0c6b8814"

EXTKERNELSRC = "${@'1' if d.getVar('EXTERNALSRC') else ''}"

# Force the use of the KBUILD_DEFCONFIG even if some other defconfig was generated in the ${WORKDIR}
do_kernel_metadata:prepend () {
	[ -n "${KBUILD_DEFCONFIG}" ] && [ -e ${WORKDIR}/defconfig ] && rm ${WORKDIR}/defconfig
}

do_configure:prepend () {
	if [ -n "${KBUILD_DEFCONFIG}" ] && [ -n "${EXTKERNELSRC}" ]; then
		cp ${S}/arch/${ARCH}/configs/${KBUILD_DEFCONFIG} ${WORKDIR}/defconfig
	fi
}

inherit kernel-simpleimage

# Default to be only compatible with specific machines or soc families
COMPATIBLE_MACHINE ?= "^$"
COMPATIBLE_MACHINE:zynq = ".*"
COMPATIBLE_MACHINE:zynqmp = ".*"
COMPATIBLE_MACHINE:microblaze = ".*"
COMPATIBLE_MACHINE:versal = ".*"

# Use DEFCONFIGs for configuring linux-xlnx kernels
KCONFIG_MODE ?= "alldefconfig"
KBUILD_DEFCONFIG:zynqmp = "xilinx_zynqmp_defconfig"
KBUILD_DEFCONFIG:zynq = "xilinx_zynq_defconfig"
KBUILD_DEFCONFIG:microblaze = "mmu_defconfig"
KBUILD_DEFCONFIG:versal = "xilinx_versal_defconfig"

# Add meta-xilinx kmeta, used for MicroBlaze BSP fragments
FILESEXTRAPATHS:prepend := "${THISDIR}:"
SRC_URI:append = " file://xilinx-kmeta;type=kmeta;name=xilinx-kmeta;destsuffix=xilinx-kmeta"

# MicroBlaze BSP fragments
KERNEL_FEATURES:append:kc705-microblazeel = " bsp/kc705-microblazeel/kc705-microblazeel.scc"

KERNEL_FEATURES:append:zynqmp = "${@bb.utils.contains('DISTRO_FEATURES', 'xen', ' bsp/xilinx/xen.scc', '', d)}"

KERNEL_FEATURES:append:zynqmp = "${@' features/overlay/overlay.scc' if d.getVar('FPGA_MNGR_RECONFIG_ENABLE') == '1' else ''}"

KERNEL_FEATURES:append:versal = "${@bb.utils.contains('DISTRO_FEATURES', 'xen', ' bsp/xilinx/xen.scc', '', d)}"

