package dev.mcarr.totpconverter.classes.bitwarden

import dev.mcarr.totpconverter.interfaces.bitwarden.IBitwardenImportSecureNote
import kotlinx.serialization.Serializable

@Serializable
data class BitwardenImportSecureNote(
    override val type: Int?
) : IBitwardenImportSecureNote