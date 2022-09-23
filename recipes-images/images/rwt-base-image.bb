SUMMARY = "A small image just capable of allowing a device to boot."

LICENSE = "MIT"

CORE_IMAGE_EXTRA_INSTALL += "\
    python \
    libiio-tests \
    libiio-iiod \
    i2c-tools \
    fru-tools \
    parted \
    dosfstools \
    python3-flask-socketio \
    python3-pillow \
    cpufrequtils \
    lmsensors-fancontrol \
    lmsensors-libsensors \
    lmsensors-pwmconfig \
    lmsensors-sensord \
    lmsensors-sensors \
    lmsensors-sensorsconfconvert \
    lmsensors-sensorsdetect \
"

IMAGE_INSTALL = "packagegroup-core-boot ${CORE_IMAGE_EXTRA_INSTALL}"
IMAGE_LINGUAS = " "
inherit core-image  image-buildinfo
