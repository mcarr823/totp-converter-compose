package dev.mcarr.totpconverter.classes.aegis

import dev.mcarr.totpconverter.interfaces.aegis.IAegisImportEntry
import kotlinx.serialization.Serializable
import org.json.JSONObject

@Serializable
data class AegisImportEntry(
    override val type: String,
    override val name: String,
    override val issuer: String,
    override val info: AegisImportEntryInfo
) : IAegisImportEntry