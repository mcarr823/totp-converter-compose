package dev.mcarr.totpconverter.classes.twofauth

import dev.mcarr.totpconverter.classes.GenericJson
import dev.mcarr.totpconverter.classes.GenericJsonEntry
import dev.mcarr.totpconverter.utilities.jsonDecode
import kotlinx.datetime.Clock
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json

object TwoFAuthJson {

    fun import(str: String) : GenericJson {
        val tfa = jsonDecode<TwoFAuthImportJson>(str)
        val items = tfa.data.map(::TwoFAuthJsonItem)
        return GenericJson(items)
    }

    /**
     * Export a list of GenericJsonEntry objects as a JSON string in
     * the 2FAuth format.
     *
     * "app" and "schema" are hard-coded to match the specific version
     * of 2fauth and its schema which were used when writing this class.
     *
     * @param entries List of generic json entries to export
     *
     * @see GenericJsonEntry
     * @see TwoFAuthExportJson
     * */
    fun export(entries: List<GenericJsonEntry>): String =
        Json.encodeToString(
            TwoFAuthExportJson(
                app = "2fauth_v5.1.1",
                schema = 1,
                datetime = Clock.System.now(),
                data = entries.map(GenericJsonEntry::exportTwoFAuth)
            )
        )

}