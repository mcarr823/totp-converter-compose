package dev.mcarr.totpconverter.interfaces.bitwarden

import kotlinx.datetime.Instant

interface IBitwardenImportPasswordHistory {
    val lastUsedDate: Instant
    val password: String
}