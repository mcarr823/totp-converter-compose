package dev.mcarr.totpconverter.classes.aegis

import dev.mcarr.totpconverter.classes.GenericJson
import dev.mcarr.totpconverter.classes.GenericJsonEntry
import dev.mcarr.totpconverter.utilities.toJsonArray
import org.json.JSONObject

object AegisJson{

    fun import(json: JSONObject): GenericJson {
        val aegis = json as AegisImport
        val items = aegis.db.entries.map(::AegisJsonItem)
        return GenericJson(items)
    }

    fun export(entries: List<GenericJsonEntry>): JSONObject =
        JSONObject().apply {
            put("db", JSONObject().apply {
                put("entries", entries.toJsonArray(GenericJsonEntry::exportAegis))
            })
        }

}