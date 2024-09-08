package dev.mcarr.totpconverter.interfaces.twofauth

interface ITwoFAuthImportToken{
    val otp_type: String; // totp, steamtotp
    val account: String; //email
    val service: String?; //service name
    val icon: String?; //filename, eg. myserviceicon.jpg
    val icon_mime: String?; //mime type, eg. image/jpg
    val icon_file: String?; //base64 encoded icon
    val secret: String;
    val digits: Int; //usually 6 for totp, 5 for steamotp
    val algorithm: String; //eg. sha1
    val period: Int;
    val counter: Any?;
    val legacy_uri: String; //eg. otpauth://totp/blahblah
}