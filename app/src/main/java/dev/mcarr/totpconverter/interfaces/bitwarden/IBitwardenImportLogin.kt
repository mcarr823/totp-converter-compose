package dev.mcarr.totpconverter.interfaces.bitwarden

interface IBitwardenImportLogin{
    val uris: List<IBitwardenImportLoginUri>;
    val username: String;
    val password: String;
    val totp: String?;
}