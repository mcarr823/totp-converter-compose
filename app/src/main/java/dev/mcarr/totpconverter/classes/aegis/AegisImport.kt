package dev.mcarr.totpconverter.classes.aegis

import dev.mcarr.totpconverter.interfaces.aegis.IAegisImportJson
import kotlinx.serialization.Serializable

@Serializable
data class AegisImport(
    override val db: AegisImportDb
) : IAegisImportJson