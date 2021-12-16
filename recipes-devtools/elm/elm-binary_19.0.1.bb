# Copyright (C) 2020 Cliff Brake <cbrake@bec-systems.com>
# Released under the MIT license (see COPYING.MIT for the terms)

DESCRIPTION = "Elm Compiler"
SECTION = "devel"
LICENSE = "MIT"

LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"

SRC_URI = "https://github.com/elm/compiler/releases/download/0.19.1/binary-for-linux-64-bit.gz;name=x64 \
           https://github.com/YoeDistro/compiler/releases/download/0.19.1/binary-for-linux-aarch64.tar.xz;name=aarch64 \
          "
SRC_URI[x64.sha256sum] = "e44af52bb27f725a973478e589d990a6428e115fe1bb14f03833134d6c0f155c"
SRC_URI[aarch64.sha256sum] = "25bad0f12b276a205960692ee4758375a36f2a65d87f5ef4fbcb6a3d03c20908"

inherit bin_package

S = "${WORKDIR}"

do_install:x86-64 () {
    install -D -m755 ${S}/binary-for-linux-64-bit ${D}${bindir}/elm
}

do_install:aarch64 () {
    install -D -m755 ${S}/elm ${D}${bindir}/elm
}

INSANE_SKIP:${PN} += "already-stripped"
BBCLASSEXTEND = "native nativesdk"

COMPATIBLE_HOST:class-target = "null"

