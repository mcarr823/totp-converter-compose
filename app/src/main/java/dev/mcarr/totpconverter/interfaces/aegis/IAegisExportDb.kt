package dev.mcarr.totpconverter.interfaces.aegis

interface IAegisExportDb{
    val version: Int;
    val entries: List<IAegisExportEntry>;
}