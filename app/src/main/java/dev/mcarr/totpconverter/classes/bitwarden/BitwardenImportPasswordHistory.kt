package dev.mcarr.totpconverter.classes.bitwarden

import dev.mcarr.totpconverter.interfaces.bitwarden.IBitwardenImportPasswordHistory
import kotlinx.datetime.Instant
import kotlinx.serialization.Serializable

@Serializable
data class BitwardenImportPasswordHistory(
    override val lastUsedDate: Instant,
    override val password: String
) : IBitwardenImportPasswordHistory