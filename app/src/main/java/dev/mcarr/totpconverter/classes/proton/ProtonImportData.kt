package dev.mcarr.totpconverter.classes.proton

import dev.mcarr.totpconverter.interfaces.proton.IProtonImportData
import dev.mcarr.totpconverter.interfaces.proton.IProtonImportDataPlatformSpecific
import kotlinx.serialization.Serializable

@Serializable
data class ProtonImportData(
    override val metadata: ProtonImportMetadata,
    override val type: String,
    override val content: ProtonImportContent,
    override val extraFields: List<String>,
    override val platformSpecific: Map<String, ProtonImportDataPlatformSpecific>,
    override val lastRevision: Int?
) : IProtonImportData