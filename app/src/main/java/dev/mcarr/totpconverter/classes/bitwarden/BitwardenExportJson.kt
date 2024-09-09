package dev.mcarr.totpconverter.classes.bitwarden

import dev.mcarr.totpconverter.interfaces.bitwarden.IBitwardenExportJson
import kotlinx.serialization.Serializable

@Serializable
data class BitwardenExportJson(
    override val items: List<BitwardenExportItem>
) : IBitwardenExportJson