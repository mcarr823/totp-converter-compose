package dev.mcarr.totpconverter.classes.aegis

import dev.mcarr.totpconverter.interfaces.aegis.IAegisImportEntry
import org.json.JSONObject

class AegisImportEntry(json: JSONObject) : IAegisImportEntry {
    override val type: String = json.getString("type"); // "totp", "steam"
    override val name: String = json.getString("name"); // service name
    override val issuer: String = json.getString("issuer");
    override val info = AegisImportEntryInfo(json.getJSONObject("info"));
}