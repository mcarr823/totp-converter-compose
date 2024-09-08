package dev.mcarr.totpconverter.interfaces.proton

interface IProtonImportData{
    val metadata: IProtonImportMetadata;
    val type: String; // "login"
    val content: IProtonImportContent
}