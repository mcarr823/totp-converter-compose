package dev.mcarr.totpconverter.classes.bitwarden

import dev.mcarr.totpconverter.interfaces.bitwarden.IBitwardenExportItem
import dev.mcarr.totpconverter.interfaces.bitwarden.IBitwardenExportItemLogin
import kotlinx.serialization.Serializable

@Serializable
data class BitwardenExportItem(
    override val type: Int,
    override val name: String,
    override val login: BitwardenExportItemLogin
) : IBitwardenExportItem