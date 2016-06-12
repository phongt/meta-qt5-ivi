DESCRIPTION = "Qt Neptune IVI UI"
HOMEPAGE = "http://qt-project.org"
LICENSE = "GPL-3.0 & CC-BY-NC-SA-4.0"
LIC_FILES_CHKSUM = "file://LICENSE.GPL3;md5=bc0cb4bfd3f72b3fe47b2b2d0d89762c \
    file://LICENSE.CC-BY-NC-SA;md5=b43997c5646e38480b031f080204d261 \
    file://modules/assets/fonts/OFL.txt;md5=a729250f3548d9d2deab9bfeb8a7ad51"
SECTION = "apps"
DEPENDS = "qtapplicationmanager qtivi"

require recipes-qt/qt5/qt5.inc

SRC_URI = "git://github.com/qtproject/qt-apps-neptune-ui.git;protocol=https"
SRC_URI_append = " file://0001-neptune-install-boards-and-dummyimports-qml.patch \
    file://0002-screenmanger-add-screenCount-implementation.patch"
SRCREV = "d620bda1ca2c4f9480d641ee76ec12e235dcd3a5"
PV = "1.0.0+git${SRCPV}"

S = "${WORKDIR}/git"

OE_QMAKE_CXXFLAGS_append = " -std=c++1y -fvisibility=hidden -Wall -fPIC"

RDEPENDS_${PN}-examples = " \
    ${PN}-qmlplugins \
    qtquick1-plugins \
    qtquick1-qmlplugins \
    qtquickcontrols \
    qtquickcontrols-qmlplugins \
    qtgraphicaleffects \
    qtgraphicaleffects-qmlplugins \
    qtmultimedia \
    qtmultimedia-qmlplugins \
    qtwebengine \
    qtwebengine-qmlplugins \
    qtdeclarative \
    qtdeclarative-tools \
    qtivi \
    qtapplicationmanager \
    qtapplicationmanager-dummyimports \
    qtapplicationmanager-template-opt \
"
