package dev.mcarr.totpconverter.classes.twofauth

import dev.mcarr.totpconverter.interfaces.twofauth.ITwoFAuthImportJson
import dev.mcarr.totpconverter.utilities.mapJsonArray
import org.json.JSONObject

class TwoFAuthImportJson : JSONObject(), ITwoFAuthImportJson {
    override val app = getString("app"); //eg. 2fauth_v5.1.1
    override val schema = getInt("schema");
    override val datetime = getString("app"); //eg. 2024-05-14T08:57:35.542766Z
    override val data = mapJsonArray<TwoFAuthImportToken>("data")
}