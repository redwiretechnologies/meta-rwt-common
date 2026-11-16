# GCC >= 14 (e.g. Ubuntu 26.04 hosts) makes -Wincompatible-pointer-types an
# error; bootgen's utils/src/cdo-load.c trips it. Keep it a warning.
CFLAGS:append = " -Wno-error=incompatible-pointer-types"
