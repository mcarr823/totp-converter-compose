package dev.mcarr.totpconverter.classes.bitwarden

import dev.mcarr.totpconverter.interfaces.bitwarden.IBitwardenImportLoginUri
import kotlinx.serialization.Serializable

@Serializable
data class BitwardenImportLoginUri(
    override val match: String?,
    override val uri: String
) : IBitwardenImportLoginUri