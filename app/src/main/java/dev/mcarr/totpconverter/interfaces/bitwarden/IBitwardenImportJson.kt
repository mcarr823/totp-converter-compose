package dev.mcarr.totpconverter.interfaces.bitwarden

interface IBitwardenImportJson{
    val encrypted: Boolean?
    val folders: List<IBitwardenImportFolder>?
    val items: List<IBitwardenImportItem>
}
