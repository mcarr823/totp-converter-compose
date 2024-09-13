package dev.mcarr.totpconverter.classes.proton

import dev.mcarr.totpconverter.interfaces.proton.IProtonImportVault
import dev.mcarr.totpconverter.interfaces.proton.IProtonImportVaultDisplay
import kotlinx.serialization.Serializable

@Serializable
data class ProtonImportVault(
    override val items: List<ProtonImportItem>,
    override val name: String,
    override val description: String,
    override val display: ProtonImportVaultDisplay
) : IProtonImportVault