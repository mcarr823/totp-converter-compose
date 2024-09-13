package dev.mcarr.totpconverter.interfaces.proton

interface IProtonImportVault{
    val items: List<IProtonImportItem>;
    val name: String
    val description: String
    val display: IProtonImportVaultDisplay
}