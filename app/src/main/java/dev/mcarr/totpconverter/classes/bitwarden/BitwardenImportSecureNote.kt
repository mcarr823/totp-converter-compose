package dev.mcarr.totpconverter.classes.bitwarden

import dev.mcarr.totpconverter.interfaces.bitwarden.IBitwardenImportSecureNote
import org.json.JSONObject

class BitwardenImportSecureNote : JSONObject(), IBitwardenImportSecureNote {
    override val type = getInt("type")
}