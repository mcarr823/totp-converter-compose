package dev.mcarr.totpconverter.interfaces.bitwarden

interface IBitwardenExportItem{
    val type: Int;
    val name: String;
    val login: IBitwardenExportItemLogin;
}