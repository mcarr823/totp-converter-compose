package dev.mcarr.totpconverter.classes.aegis

import dev.mcarr.totpconverter.interfaces.aegis.IAegisImportJson
import org.json.JSONObject

class AegisImport : JSONObject(), IAegisImportJson {
    override val db = getJSONObject("db") as AegisImportDb
}