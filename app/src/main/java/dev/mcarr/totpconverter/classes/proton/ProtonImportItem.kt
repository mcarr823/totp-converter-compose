package dev.mcarr.totpconverter.classes.proton

import dev.mcarr.totpconverter.interfaces.proton.IProtonImportItem
import kotlinx.serialization.Serializable

@Serializable
data class ProtonImportItem(
    override val data: ProtonImportData
) : IProtonImportItem