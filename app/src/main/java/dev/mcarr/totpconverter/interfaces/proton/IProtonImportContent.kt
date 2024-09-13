package dev.mcarr.totpconverter.interfaces.proton

interface IProtonImportContent{
    val username: String;
    val password: String;
    val urls: List<String>;
    val totpUri: String;
    val passkeys: List<String>;
}