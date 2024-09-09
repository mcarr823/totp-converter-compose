package dev.mcarr.totpconverter.classes.proton

import dev.mcarr.totpconverter.interfaces.proton.IProtonImportData
import kotlinx.serialization.Serializable

@Serializable
data class ProtonImportData(
    override val metadata: ProtonImportMetadata,
    override val type: String,
    override val content: ProtonImportContent
) : IProtonImportData