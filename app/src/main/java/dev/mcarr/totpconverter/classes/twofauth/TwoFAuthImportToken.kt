package dev.mcarr.totpconverter.classes.twofauth

import dev.mcarr.totpconverter.interfaces.twofauth.ITwoFAuthImportToken
import org.json.JSONObject

class TwoFAuthImportToken : JSONObject(), ITwoFAuthImportToken {
    override val otp_type = getString("otp_type")
    override val account = getString("account")
    override val service = optString("service")
    override val icon = optString("icon")
    override val icon_mime = optString("icon_mime")
    override val icon_file = optString("icon_file")
    override val secret = getString("secret")
    override val digits = getInt("digits")
    override val algorithm = getString("algorithm")
    override val period = getInt("period")
    override val counter = null
    override val legacy_uri = getString("legacy_uri")
}