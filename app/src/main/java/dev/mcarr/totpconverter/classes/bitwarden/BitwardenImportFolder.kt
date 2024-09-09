package dev.mcarr.totpconverter.classes.bitwarden

import dev.mcarr.totpconverter.interfaces.bitwarden.IBitwardenImportFolder
import kotlinx.serialization.Serializable

@Serializable
data class BitwardenImportFolder(
    override val id: String,
    override val name: String
) : IBitwardenImportFolder