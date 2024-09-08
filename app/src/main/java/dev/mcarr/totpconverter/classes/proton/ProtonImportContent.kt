package dev.mcarr.totpconverter.classes.proton

import dev.mcarr.totpconverter.interfaces.proton.IProtonImportContent
import dev.mcarr.totpconverter.utilities.toStringList
import org.json.JSONObject

class ProtonImportContent : JSONObject(), IProtonImportContent{
    override val username = getString("username");
    override val urls = getJSONArray("urls").toStringList()
    override val totpUri = getString("totpUri");
}