package dev.mcarr.totpconverter.classes.aegis

import dev.mcarr.totpconverter.interfaces.aegis.IAegisImportJson
import org.json.JSONObject

class AegisImport(json: JSONObject) : IAegisImportJson {
    override val db = AegisImportDb(json.getJSONObject("db"))
}