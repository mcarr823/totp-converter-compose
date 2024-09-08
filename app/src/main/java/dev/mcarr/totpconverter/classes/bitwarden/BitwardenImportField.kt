package dev.mcarr.totpconverter.classes.bitwarden

import dev.mcarr.totpconverter.interfaces.bitwarden.IBitwardenImportField
import org.json.JSONObject

class BitwardenImportField : JSONObject(), IBitwardenImportField {
    override val name = getString("name")
    override val value = getString("value")
    override val type = getInt("type")
    override val linkedId = null
}