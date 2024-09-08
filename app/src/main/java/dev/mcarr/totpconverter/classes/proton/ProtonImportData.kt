package dev.mcarr.totpconverter.classes.proton

import dev.mcarr.totpconverter.interfaces.proton.IProtonImportData
import org.json.JSONObject

class ProtonImportData : JSONObject(), IProtonImportData{
    override val metadata = getJSONObject("metadata") as ProtonImportMetadata
    override val type: String = getString("type")
    override val content = getJSONObject("content") as ProtonImportContent
}