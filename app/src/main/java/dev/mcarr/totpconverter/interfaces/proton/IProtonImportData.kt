package dev.mcarr.totpconverter.interfaces.proton

interface IProtonImportData{
    val metadata: IProtonImportMetadata;
    val extraFields: List<String>;
    val type: String; // "login"
    val content: IProtonImportContent
    val platformSpecific: Map<String, IProtonImportDataPlatformSpecific>
    val lastRevision: Int?
}