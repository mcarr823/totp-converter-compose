package dev.mcarr.totpconverter.interfaces.aegis

interface IAegisImportEntry{
    val type: String; // "totp", "steam"
    val name: String; // service name
    val issuer: String;
    val info: IAegisImportEntryInfo;
}