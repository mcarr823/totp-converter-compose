package dev.mcarr.totpconverter.interfaces.proton

interface IProtonImportAllowedApp {
    val packageName: String;
    val hashes: List<String>;
    val appName: String;
}