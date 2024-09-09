package dev.mcarr.totpconverter.classes.twofauth

import dev.mcarr.totpconverter.classes.GenericJson
import dev.mcarr.totpconverter.classes.GenericJsonEntry
import dev.mcarr.totpconverter.utilities.jsonDecode
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json

object TwoFAuthJson {

    fun import(str: String) : GenericJson {
        val tfa = jsonDecode<TwoFAuthImportJson>(str)
        val items = tfa.data.map(::TwoFAuthJsonItem)
        return GenericJson(items)
    }

    fun export(entries: List<GenericJsonEntry>): String =
        Json.encodeToString(
            TwoFAuthExportJson(
                data = entries.map {
                    it.exportTwoFAuth()
                }
            )
        )

}