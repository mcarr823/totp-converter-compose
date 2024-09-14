package dev.mcarr.totpconverter.interfaces.aegis

interface IAegisImportDb{
    val version: Int;
    val entries: List<IAegisImportEntry>;
}