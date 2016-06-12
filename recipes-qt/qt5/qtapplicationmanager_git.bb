DESCRIPTION = "Qt5 application manager"
HOMEPAGE = "http://qt-project.org"
LICENSE = "GFDL-1.3 & GPL-2.0 & GPL-3.0 & GPL3-EXCEPT & LGPL-3.0"
LIC_FILES_CHKSUM = "file://LICENSE.FDL;md5=6d9f2a9af4c8b8c3c769f6cc1b6aaf7e \
    file://LICENSE.GPL2;md5=b234ee4d69f5fce4486a80fdaf4a4263 \
    file://LICENSE.GPL3;md5=317fda864ac33d41406ff3938c3e78d1 \
    file://LICENSE.GPL3-EXCEPT;md5=763d8c535a234d9a3fb682c7ecb6c073 \
    file://LICENSE.LGPL3;md5=e6a600fd5e1d9cbde2d983680233ad02"
SECTION = "libs"
DEPENDS = "zlib libyaml openssl libarchive"
DEPENDS_append = " qtquick1 qtwayland qtquickcontrols qtdeclarative qtivi"

require recipes-qt/qt5/qt5.inc

SRC_URI = "git://github.com/qtproject/qtapplicationmanager.git;protocol=https;branch=5.7"
SRCREV = "4e5a6cb9d5573f28996f16f1a7aceacf9b45d392"
PV = "1.0.0+git${SRCPV}"

S = "${WORKDIR}/git"

OE_QMAKE_CXXFLAGS_append = " -std=c++1y -fvisibility=hidden -Wall -fPIC"

EXTRA_QMAKEVARS_PRE = " \
    -config install-prefix=${OE_QMAKE_PATH_PREFIX} \
    -config enable-tests \
"

do_install_append () {
    # install dummyimports
    install -d ${D}${datadir}/QtApplicationManager
    install -m 664 ${S}/dummyimports/QtApplicationManager/* ${D}${datadir}/QtApplicationManager/

    # install am config template
    install -d ${D}/opt
    cp -r ${S}/template-opt/am ${D}/opt 
}

PACKAGES_append = " \
    ${PN}-tests \
    ${PN}-dummyimports \
    ${PN}-template-opt \
"

FILES_${PN} = " \
    ${bindir}/appman* \
    ${datadir}/dbus-1 \
"

FILES_${PN}-tests = " \
    ${bindir}/tst_* \
"

FILES_${PN}-dummyimports = " \
    ${datadir}/QtApplicationManager \
"

FILES_${PN}-template-opt = " \
    /opt/am \
"
