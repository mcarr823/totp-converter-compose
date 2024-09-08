package dev.mcarr.totpconverter.interfaces

interface IGenericJsonEntry{

    val type: String; // "totp", "steam"
    val name: String; // service name
    val issuer: String;
    val secret: String;
    val algo: String; // eg. "SHA1"
    val digits: Int; // 6 for totp, 5 for steam,
    val period: Int; // usually 30
    val websites: List<String>;

}