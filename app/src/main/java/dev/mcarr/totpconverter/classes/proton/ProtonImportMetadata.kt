package dev.mcarr.totpconverter.classes.proton

import dev.mcarr.totpconverter.interfaces.proton.IProtonImportMetadata
import kotlinx.serialization.Serializable

@Serializable
data class ProtonImportMetadata(
    override val name: String,
    override val note: String,
    override val itemUuid: String
) : IProtonImportMetadata