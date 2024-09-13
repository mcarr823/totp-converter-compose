package dev.mcarr.totpconverter.interfaces.proton

interface IProtonImportJson {
    val encrypted: Boolean;
    val vaults: Map<String, IProtonImportVault>
}
