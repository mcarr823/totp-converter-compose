package dev.mcarr.totpconverter.classes.bitwarden

import dev.mcarr.totpconverter.interfaces.bitwarden.IBitwardenImportJson
import dev.mcarr.totpconverter.utilities.mapJsonArray
import org.json.JSONObject

class BitwardenImportJson : JSONObject(), IBitwardenImportJson {
    override val encrypted = getBoolean("encrypted");
    override val folders = mapJsonArray<BitwardenImportFolder>("folders")
    override val items = mapJsonArray<BitwardenImportItem>("items")
}