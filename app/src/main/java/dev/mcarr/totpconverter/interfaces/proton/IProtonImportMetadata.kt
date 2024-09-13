package dev.mcarr.totpconverter.interfaces.proton

interface IProtonImportMetadata{
    val name: String; // issuer
    val note: String;
    val itemUuid: String;
}