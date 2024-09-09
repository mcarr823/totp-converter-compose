package dev.mcarr.totpconverter.interfaces.aegis

interface IAegisExportEntry{
    val type: String
    val name: String
    val issuer: String
    val info: IAegisExportEntryInfo
}