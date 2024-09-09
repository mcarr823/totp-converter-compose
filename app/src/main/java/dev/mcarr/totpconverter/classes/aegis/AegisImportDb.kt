package dev.mcarr.totpconverter.classes.aegis

import dev.mcarr.totpconverter.interfaces.aegis.IAegisImportDb
import dev.mcarr.totpconverter.utilities.mapJsonArray
import kotlinx.serialization.Serializable
import org.json.JSONObject

@Serializable
data class AegisImportDb(
    override val entries: List<AegisImportEntry>
) : IAegisImportDb