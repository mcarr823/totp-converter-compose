package dev.mcarr.totpconverter.classes.bitwarden

import dev.mcarr.totpconverter.interfaces.bitwarden.IBitwardenImportLogin
import kotlinx.serialization.Serializable

@Serializable
data class BitwardenImportLogin(
    override val uris: List<BitwardenImportLoginUri>,
    override val username: String?,
    override val password: String?,
    override val totp: String?
) : IBitwardenImportLogin