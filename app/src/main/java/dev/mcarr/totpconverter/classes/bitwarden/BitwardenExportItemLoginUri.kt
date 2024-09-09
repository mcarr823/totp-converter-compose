package dev.mcarr.totpconverter.classes.bitwarden

import dev.mcarr.totpconverter.interfaces.bitwarden.IBitwardenExportItemLoginUri
import kotlinx.serialization.Serializable

@Serializable
data class BitwardenExportItemLoginUri(
    override val match: String?,
    override val uri: String
) : IBitwardenExportItemLoginUri
