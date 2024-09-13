package dev.mcarr.totpconverter.classes.proton

import dev.mcarr.totpconverter.interfaces.proton.IProtonImportAllowedApp
import dev.mcarr.totpconverter.interfaces.proton.IProtonImportDataPlatformSpecific
import kotlinx.serialization.Serializable

@Serializable
data class ProtonImportDataPlatformSpecific(
    override val allowedApps: List<ProtonImportAllowedApp>?
): IProtonImportDataPlatformSpecific