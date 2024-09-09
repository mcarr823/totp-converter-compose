package dev.mcarr.totpconverter.classes.bitwarden

import dev.mcarr.totpconverter.interfaces.bitwarden.IBitwardenImportField
import kotlinx.serialization.Serializable

@Serializable
data class BitwardenImportField(
    override val name: String,
    override val value: String,
    override val type: Int,
    override val linkedId: String?
) : IBitwardenImportField