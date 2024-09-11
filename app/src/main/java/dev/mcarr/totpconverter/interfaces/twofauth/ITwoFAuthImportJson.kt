package dev.mcarr.totpconverter.interfaces.twofauth

import kotlinx.datetime.Instant

interface ITwoFAuthImportJson{
    val app: String //eg. 2fauth_v5.1.1
    val schema: Int
    val datetime: Instant //eg. 2024-05-14T08:57:35.542766Z
    val data: List<ITwoFAuthImportToken>
}

