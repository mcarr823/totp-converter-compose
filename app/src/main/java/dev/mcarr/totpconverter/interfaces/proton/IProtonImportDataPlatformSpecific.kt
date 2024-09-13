package dev.mcarr.totpconverter.interfaces.proton

interface IProtonImportDataPlatformSpecific {
    val allowedApps: List<IProtonImportAllowedApp>?;
}