package dev.mcarr.totpconverter.interfaces.aegis

interface IAegisImportEntryInfo{
    val secret: String;
    val algo: String; // eg. "SHA1"
    val digits: Int; // 6 for totp, 5 for steam,
    val period: Int; // usually 30
}