FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}:"

SRC_URI_append = " file://0001-Install-the-static-qtfreetype-lib.patch"
