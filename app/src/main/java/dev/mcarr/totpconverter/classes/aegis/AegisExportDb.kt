package dev.mcarr.totpconverter.classes.aegis

import dev.mcarr.totpconverter.interfaces.aegis.IAegisExportDb
import dev.mcarr.totpconverter.interfaces.aegis.IAegisExportEntry
import kotlinx.serialization.Serializable

@Serializable
data class AegisExportDb(
    override val version: Int,
    override val entries: List<AegisExportEntry>
) : IAegisExportDb
