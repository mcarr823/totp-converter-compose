package dev.mcarr.totpconverter.classes.bitwarden

import dev.mcarr.totpconverter.classes.GenericJson
import dev.mcarr.totpconverter.classes.GenericJsonEntry
import dev.mcarr.totpconverter.interfaces.bitwarden.IBitwardenImportJson
import dev.mcarr.totpconverter.utilities.toJsonArray
import org.json.JSONObject

object BitwardenJson{

    fun import(json: JSONObject): GenericJson {

        val bw = json as BitwardenImportJson
        val items = bw.items.mapNotNull{
            try{
                BitwardenJsonItem(it)
            }catch(e: Exception){
                e.printStackTrace()
                null
            }
        }

        return GenericJson(items)

    }

    fun export(entries: List<GenericJsonEntry>): JSONObject =
        JSONObject().apply {
            put("items", entries.toJsonArray(GenericJsonEntry::exportBitwarden))
        }

}