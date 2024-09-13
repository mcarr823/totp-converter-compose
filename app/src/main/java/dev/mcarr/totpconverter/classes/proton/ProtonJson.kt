package dev.mcarr.totpconverter.classes.proton

import dev.mcarr.totpconverter.classes.GenericJson
import dev.mcarr.totpconverter.classes.GenericJsonEntry
import dev.mcarr.totpconverter.interfaces.proton.IProtonImportJson
import dev.mcarr.totpconverter.utilities.jsonDecode
import kotlinx.serialization.json.Json
import org.json.JSONObject

object ProtonJson {

    fun import(str: String) : GenericJson {

        val proton = jsonDecode<ProtonImport>(str)

        if (proton.encrypted)
            throw Exception("Encrypted JSON not supported");

        val entries: List<GenericJsonEntry> =
            proton.vaults.values.flatMap { it.items }
                .map{ it.data }
                .filter{ it.type == "login" }
                .mapNotNull{
                    try{
                        ProtonJsonItem(it)
                    }catch(e: Exception){
                        e.printStackTrace()
                        null
                    }
                }

        return GenericJson(entries)

    }

}

