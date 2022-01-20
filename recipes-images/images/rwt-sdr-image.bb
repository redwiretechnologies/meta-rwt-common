SUMMARY = "An SDR development image for RWT based platforms, each platform may append this"

LICENSE = "MIT"

IMAGE_FEATURES += "splash ssh-server-openssh debug-tweaks "
EXTRA_IMAGE_FEATURES += "tools-debug tools-profile tools-sdk dev-pkgs package-management"

CORE_IMAGE_EXTRA_INSTALL += "\
    packagegroup-sdr-base-extended \
    packagegroup-sdr-base-debug \
    packagegroup-sdr-base-devel \
    packagegroup-sdr-base-python \
    gnuradio \
    ${@bb.utils.contains('DISTRO_FEATURES', 'x11', 'xauth', '', d)} \
    libiio-tests \
    libiio-iiod \
    i2c-tools \
    fru-tools \
    parted \
    dosfstools \
    python3-flask-socketio \
    python3-pillow \
    python3-eventlet \
    gr-rwt \
    iptables \
    networkmanager \
    networkmanager-nmtui \
    python3-networkmanager \
    libmbim \
    libqmi \
    modemmanager \
    hostapd \
    gpsd \
    gpsd-gpsctl \
    gps-utils \
    fpga-manager-script \
    fclkcfg-mod \
    cpufrequtils \
    lmsensors-fancontrol \
    lmsensors-libsensors \
    lmsensors-pwmconfig \
    lmsensors-sensord \
    lmsensors-sensors \
    lmsensors-sensorsconfconvert \
    lmsensors-sensorsdetect \
    libgpiod \
    libgpiod-tools \
    python3-six \
    bitfiles-griio \
    bitfiles-default \
    ttf-dejavu-sans \
    ttf-dejavu-sans-mono \
    ttf-dejavu-serif \
    ttf-dejavu-serif-condensed \
    ttf-dejavu-common \
    fontconfig \
"

inherit core-image
