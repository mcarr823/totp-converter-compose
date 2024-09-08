package dev.mcarr.totpconverter.interfaces.aegis

interface IAegisExportJson{
    val version: Int;
    val header: IAegisExportHeader;
    val db: IAegisExportDb;
}
