package dev.mcarr.totpconverter.classes.aegis

import dev.mcarr.totpconverter.interfaces.aegis.IAegisImportEntryInfo
import kotlinx.serialization.Serializable

@Serializable
data class AegisImportEntryInfo(
    override val secret: String,
    override val algo: String,
    override val digits: Int,
    override val period: Int
) : IAegisImportEntryInfo