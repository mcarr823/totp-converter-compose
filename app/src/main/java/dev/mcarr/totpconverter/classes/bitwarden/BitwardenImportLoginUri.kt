package dev.mcarr.totpconverter.classes.bitwarden

import dev.mcarr.totpconverter.interfaces.bitwarden.IBitwardenImportLoginUri
import org.json.JSONObject

class BitwardenImportLoginUri : JSONObject(), IBitwardenImportLoginUri {
    override val match = null
    override val uri = getString("uri")
}