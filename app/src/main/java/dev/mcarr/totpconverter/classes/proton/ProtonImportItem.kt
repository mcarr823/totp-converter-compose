package dev.mcarr.totpconverter.classes.proton

import dev.mcarr.totpconverter.interfaces.proton.IProtonImportItem
import org.json.JSONObject

class ProtonImportItem : JSONObject(), IProtonImportItem {
    override val data = getJSONObject("data") as ProtonImportData
}