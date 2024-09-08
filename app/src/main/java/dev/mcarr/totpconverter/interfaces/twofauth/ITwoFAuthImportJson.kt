package dev.mcarr.totpconverter.interfaces.twofauth

interface ITwoFAuthImportJson{
    val app: String; //eg. 2fauth_v5.1.1
    val schema: Int;
    val datetime: String; //eg. 2024-05-14T08:57:35.542766Z
    val data: List<ITwoFAuthImportToken>;
}

