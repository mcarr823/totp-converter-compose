package dev.mcarr.totpconverter.classes.bitwarden

import dev.mcarr.totpconverter.classes.GenericJson
import dev.mcarr.totpconverter.classes.GenericJsonEntry
import dev.mcarr.totpconverter.interfaces.bitwarden.IBitwardenImportJson
import dev.mcarr.totpconverter.utilities.jsonDecode
import dev.mcarr.totpconverter.utilities.toJsonArray
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import org.json.JSONObject

object BitwardenJson{

    fun import(str: String): GenericJson {

        val bw = jsonDecode<BitwardenImportJson>(str)
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

    fun export(entries: List<GenericJsonEntry>): String =
        Json.encodeToString(
            BitwardenExportJson(
                items = entries.map {
                    it.exportBitwarden()
                }
            )
        )

}