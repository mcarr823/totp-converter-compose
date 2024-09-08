package dev.mcarr.totpconverter.classes.aegis

import dev.mcarr.totpconverter.interfaces.aegis.IAegisImportEntryInfo
import org.json.JSONObject

class AegisImportEntryInfo : JSONObject(), IAegisImportEntryInfo {
    override val secret = getString("secret")
    override val algo = getString("algo")
    override val digits = getInt("digits")
    override val period = getInt("period")
}