package dev.mcarr.totpconverter.classes.aegis

import dev.mcarr.totpconverter.interfaces.aegis.IAegisImportEntryInfo
import org.json.JSONObject

class AegisImportEntryInfo(json: JSONObject) : IAegisImportEntryInfo {
    override val secret: String = json.getString("secret");
    override val algo: String = json.getString("algo"); // eg. "SHA1"
    override val digits: Int = json.getInt("digits"); // 6 for totp, 5 for steam,
    override val period: Int = json.getInt("period"); // usually 30
}