package dev.mcarr.totpconverter.classes.bitwarden

import dev.mcarr.totpconverter.interfaces.bitwarden.IBitwardenImportLogin
import dev.mcarr.totpconverter.utilities.mapJsonArray
import org.json.JSONObject

class BitwardenImportLogin : JSONObject(), IBitwardenImportLogin {
    override val uris = mapJsonArray<BitwardenImportLoginUri>("uris")
    override val username = getString("username");
    override val password = getString("password");
    override val totp = optString("json");
}