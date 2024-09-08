package dev.mcarr.totpconverter.interfaces.bitwarden

interface IBitwardenImportField{
    val name: String;
    val value: String;
    val type: Int;
    val linkedId: Any?;
}