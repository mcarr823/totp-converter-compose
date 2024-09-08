package dev.mcarr.totpconverter.classes.proton

import dev.mcarr.totpconverter.interfaces.proton.IProtonImportMetadata
import org.json.JSONObject

class ProtonImportMetadata : JSONObject(), IProtonImportMetadata {
    override val name = getString("name")
}