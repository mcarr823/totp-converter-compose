package dev.mcarr.totpconverter.interfaces.aegis

interface IAegisExportEntry{
    val type: String; // "totp", "steam"
    val uuid: String;
    val name: String; // service name
    val issuer: String;
    val note: String;
    val favorite: Boolean;
    val icon: Any?;
    val info: IAegisExportInfo;
    val groups: List<String>; // this data type is probably wrong
}