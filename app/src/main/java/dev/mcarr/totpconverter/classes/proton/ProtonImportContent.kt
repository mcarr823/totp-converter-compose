package dev.mcarr.totpconverter.classes.proton

import dev.mcarr.totpconverter.interfaces.proton.IProtonImportContent
import kotlinx.serialization.Serializable

@Serializable
data class ProtonImportContent(
    override val username: String,
    override val password: String,
    override val urls: List<String>,
    override val totpUri: String,
    override val passkeys: List<String>
) : IProtonImportContent