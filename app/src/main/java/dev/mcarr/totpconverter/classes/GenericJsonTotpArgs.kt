package dev.mcarr.totpconverter.classes

data class GenericJsonTotpArgs(
    val name: String,
    val issuer: String,
    val secret: String,
    val algo: String, // eg. "SHA1"
    val digits: Int, // 6 for totp, 5 for steam,
    val period: Int // usually 30
)