package dev.mcarr.totpconverter.classes.aegis

import dev.mcarr.totpconverter.interfaces.aegis.IAegisImportDb
import dev.mcarr.totpconverter.utilities.mapJsonArray
import org.json.JSONObject

class AegisImportDb : JSONObject(), IAegisImportDb {

    override val entries = mapJsonArray<AegisImportEntry>("entries")

}