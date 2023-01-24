# This version extension should match CONFIG_LOCALVERSION in defconfig
XILINX_RELEASE_VERSION ?= ""
LINUX_VERSION_EXTENSION ?= "-xilinx-${XILINX_RELEASE_VERSION}"
PV = "${LINUX_VERSION}${LINUX_VERSION_EXTENSION}+git${SRCPV}"

# Sources, by default allow for the use of SRCREV pointing to orphaned tags/commits
KBRANCH ?= "master"
SRCBRANCHARG = "${@['nobranch=1', 'branch=${KBRANCH}'][d.getVar('KBRANCH', True) != '']}"

FILESOVERRIDES:append = ":${XILINX_RELEASE_VERSION}"
KERNELURI ?= "git://github.com/analogdevicesinc/linux.git;protocol=https"
YOCTO_META ?= "git://git.yoctoproject.org/yocto-kernel-cache;type=kmeta;name=meta;branch=yocto-5.10;destsuffix=yocto-kmeta"
SRC_URI = "${KERNELURI};${SRCBRANCHARG} \
           file://dt-overlay.cfg \
           file://0002-Adding-symbols-to-DTB-to-support-overlays.patch \
	   file://0004-arm-zynq-Add-support-for-cpufreq.patch \
	   ${YOCTO_META} \
	   "

FPGA_MNGR_RECONFIG_ENABLE = "1"
SRCREV_machine ?= "${SRCREV}"
SRCREV_meta ?= "648713579b9076c25a3eb93ba1a96f2577ffca20"
SRCREV_FORMAT = "machine"

require recipes-kernel/linux/linux-yocto.inc

LINUX_MB_INC = ""
LINUX_MB_INC:microblaze = "linux-microblaze.inc"
require ${LINUX_MB_INC}

DESCRIPTION = "Xilinx Kernel"
LIC_FILES_CHKSUM = "file://COPYING;md5=6bc538ed5bd9a7fc9398086aedcd7e46"

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
KBUILD_DEFCONFIG:zynqmp = "adi_zynqmp_defconfig"
KBUILD_DEFCONFIG:zynq = "xilinx_zynq_defconfig"
KBUILD_DEFCONFIG:microblaze = "mmu_defconfig"
KBUILD_DEFCONFIG:versal = "xilinx_versal_defconfig"

# Add meta-xilinx kmeta, used for MicroBlaze BSP fragments
FILESEXTRAPATHS:prepend := "${THISDIR}:"
SRC_URI:append = " file://adi-kmeta;type=kmeta;name=adi-kmeta;destsuffix=adi-kmeta"

# MicroBlaze BSP fragments
KERNEL_FEATURES:append:kc705-microblazeel = " bsp/kc705-microblazeel/kc705-microblazeel.scc"

KERNEL_FEATURES:append:zynqmp = "${@bb.utils.contains('DISTRO_FEATURES', 'xen', ' bsp/xilinx/xen.scc', '', d)}"

KERNEL_FEATURES:append:zynqmp = " features/overlay/overlay.scc"

KERNEL_FEATURES:append:versal = "${@bb.utils.contains('DISTRO_FEATURES', 'xen', ' bsp/xilinx/xen.scc', '', d)}"

KERNEL_FEATURES:append = " ${@bb.utils.contains('MACHINE_FEATURES', 'vfat', 'cfg/fs/vfat.scc', '', d)}"

