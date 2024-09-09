package dev.mcarr.totpconverter.classes.twofauth

import dev.mcarr.totpconverter.interfaces.twofauth.ITwoFAuthImportToken
import kotlinx.serialization.Serializable

@Serializable
data class TwoFAuthImportToken(
    override val otp_type: String,
    override val account: String,
    override val service: String?,
    override val icon: String?,
    override val icon_mime: String?,
    override val icon_file: String?,
    override val secret: String,
    override val digits: Int,
    override val algorithm: String,
    override val period: Int,
    override val counter: Int?,
    override val legacy_uri: String
) : ITwoFAuthImportToken