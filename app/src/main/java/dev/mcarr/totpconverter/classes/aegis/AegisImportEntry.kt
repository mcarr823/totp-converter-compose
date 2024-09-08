package dev.mcarr.totpconverter.classes.aegis

import dev.mcarr.totpconverter.interfaces.aegis.IAegisImportEntry
import org.json.JSONObject

class AegisImportEntry : JSONObject(), IAegisImportEntry {
    override val type: String = getString("type")
    override val name: String = getString("name")
    override val issuer: String = getString("issuer")
    override val info = getJSONObject("info") as AegisImportEntryInfo
}