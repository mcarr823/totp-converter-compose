package dev.mcarr.totpconverter.interfaces.twofauth

interface ITwoFAuthExportItem{
    val otp_type: String;
    val account: String;
    val service: String;
    val secret: String;
    val digits: Int;
    val algorithm: String;
    val period: Int;
    val counter: Any?;
    val legacy_uri: String;
}