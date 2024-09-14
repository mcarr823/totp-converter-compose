package dev.mcarr.totpconverter.classes.aegis

import dev.mcarr.totpconverter.classes.GenericJson
import dev.mcarr.totpconverter.classes.GenericJsonEntry
import dev.mcarr.totpconverter.utilities.jsonDecode
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json

object AegisJson{

    fun import(str: String): GenericJson {
        val aegis = jsonDecode<AegisImport>(str)
        val items = aegis.db.entries.map(::AegisJsonItem)
        return GenericJson(items)
    }

    fun export(entries: List<GenericJsonEntry>): String =
        Json.encodeToString(
            AegisExport(
                db = AegisExportDb(
                    version = 3,
                    entries = entries.map {
                        it.exportAegis()
                    }
                )
            )
        )

}