package dev.mcarr.totpconverter.classes.aegis

import dev.mcarr.totpconverter.interfaces.aegis.IAegisImportDb
import dev.mcarr.totpconverter.utilities.toObjectList
import org.json.JSONObject

class AegisImportDb(json: JSONObject) : IAegisImportDb {

    override val entries = json
        .getJSONArray("entries")
        .toObjectList()
        .map(::AegisImportEntry)

}