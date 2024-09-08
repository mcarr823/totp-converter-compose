package dev.mcarr.totpconverter.classes.twofauth

import dev.mcarr.totpconverter.classes.GenericJson
import dev.mcarr.totpconverter.classes.GenericJsonEntry
import dev.mcarr.totpconverter.utilities.toJsonArray
import org.json.JSONObject

object TwoFAuthJson {

    fun import(json: JSONObject) : GenericJson {
        val tfa = json as TwoFAuthImportJson
        val items = tfa.data.map(::TwoFAuthJsonItem)
        return GenericJson(items)
    }

    fun export(entries: List<GenericJsonEntry>): JSONObject =
        JSONObject().apply {
            put("data", entries.toJsonArray(GenericJsonEntry::exportTwoFAuth))
        }

}