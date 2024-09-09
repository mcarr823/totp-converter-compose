package dev.mcarr.totpconverter.classes.bitwarden

import dev.mcarr.totpconverter.interfaces.bitwarden.IBitwardenExportItemLogin
import dev.mcarr.totpconverter.interfaces.bitwarden.IBitwardenExportItemLoginUri
import kotlinx.serialization.Serializable

@Serializable
data class BitwardenExportItemLogin(
    override val totp: String,
    override val uris: List<BitwardenExportItemLoginUri>
) : IBitwardenExportItemLogin
