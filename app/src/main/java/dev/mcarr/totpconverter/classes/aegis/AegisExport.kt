package dev.mcarr.totpconverter.classes.aegis

import dev.mcarr.totpconverter.interfaces.aegis.IAegisExportDb
import dev.mcarr.totpconverter.interfaces.aegis.IAegisExportJson
import kotlinx.serialization.Serializable

@Serializable
data class AegisExport(
    override val db: AegisExportDb
) : IAegisExportJson
