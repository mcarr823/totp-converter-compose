package dev.mcarr.totpconverter.interfaces.bitwarden

interface IBitwardenImportCard{
    val cardholderName: String;
    val brand: Any?;
    val number: String;
    val expMonth: String;
    val expYear: String;
    val code: String;
}