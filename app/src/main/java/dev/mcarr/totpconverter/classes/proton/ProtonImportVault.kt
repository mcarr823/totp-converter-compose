package dev.mcarr.totpconverter.classes.proton

import dev.mcarr.totpconverter.interfaces.proton.IProtonImportVault
import dev.mcarr.totpconverter.utilities.mapJsonArray
import org.json.JSONObject

class ProtonImportVault : JSONObject(), IProtonImportVault{
    override val items = mapJsonArray<ProtonImportItem>("items")
}