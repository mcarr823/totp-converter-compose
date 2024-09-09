package dev.mcarr.totpconverter.classes.bitwarden

import dev.mcarr.totpconverter.interfaces.bitwarden.IBitwardenImportCard
import kotlinx.serialization.Serializable

@Serializable
data class BitwardenImportCard(
    override val cardholderName: String?,
    override val brand: String?,
    override val number: String?,
    override val expMonth: String?,
    override val expYear: String?,
    override val code: String?
) : IBitwardenImportCard