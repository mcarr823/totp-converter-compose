package dev.mcarr.totpconverter.classes.proton

import dev.mcarr.totpconverter.interfaces.proton.IProtonImportAllowedApp
import kotlinx.serialization.Serializable

@Serializable
data class ProtonImportAllowedApp(
    override val packageName: String,
    override val hashes: List<String>,
    override val appName: String
) : IProtonImportAllowedApp