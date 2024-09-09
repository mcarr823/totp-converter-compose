package dev.mcarr.totpconverter.classes.bitwarden

import dev.mcarr.totpconverter.interfaces.bitwarden.IBitwardenImportJson
import kotlinx.serialization.Serializable

@Serializable
data class BitwardenImportJson(
    override val encrypted: Boolean,
    override val folders: List<BitwardenImportFolder>,
    override val items: List<BitwardenImportItem>
) : IBitwardenImportJson