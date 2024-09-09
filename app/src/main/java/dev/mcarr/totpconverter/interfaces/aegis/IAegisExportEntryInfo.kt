package dev.mcarr.totpconverter.interfaces.aegis

interface IAegisExportEntryInfo {
    val secret: String
    val algo: String
    val digits: Int
    val period: Int
}