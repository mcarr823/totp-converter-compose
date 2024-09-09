package dev.mcarr.totpconverter.classes.proton

import dev.mcarr.totpconverter.interfaces.proton.IProtonImportVault
import kotlinx.serialization.Serializable

@Serializable
data class ProtonImportVault(
    override val items: List<ProtonImportItem>
) : IProtonImportVault