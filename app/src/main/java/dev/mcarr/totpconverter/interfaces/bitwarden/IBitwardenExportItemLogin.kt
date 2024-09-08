package dev.mcarr.totpconverter.interfaces.bitwarden

interface IBitwardenExportItemLogin{
    val totp: String;
    val uris: Array<IBitwardenExportItemLoginUri>;
}