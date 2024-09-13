package dev.mcarr.totpconverter.interfaces.proton

interface IProtonImportItem{
    val data: IProtonImportData
    val itemId: String
    val shareId: String
    val state: Int
    val aliasEmail: String?
    val contentFormatVersion: Int
    val createTime: Long
    val modifyTime: Long
    val pinned: Boolean
}