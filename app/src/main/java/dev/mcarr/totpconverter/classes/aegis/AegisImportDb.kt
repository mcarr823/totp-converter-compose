package dev.mcarr.totpconverter.classes.aegis

import dev.mcarr.totpconverter.interfaces.aegis.IAegisImportDb
import kotlinx.serialization.Serializable

@Serializable
data class AegisImportDb(
    override val entries: List<AegisImportEntry>
) : IAegisImportDb