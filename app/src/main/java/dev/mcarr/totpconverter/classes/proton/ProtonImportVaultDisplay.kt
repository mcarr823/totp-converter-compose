package dev.mcarr.totpconverter.classes.proton

import dev.mcarr.totpconverter.interfaces.proton.IProtonImportVaultDisplay
import kotlinx.serialization.Serializable

@Serializable
data class ProtonImportVaultDisplay(
    override val color: Int,
    override val icon: Int
) : IProtonImportVaultDisplay