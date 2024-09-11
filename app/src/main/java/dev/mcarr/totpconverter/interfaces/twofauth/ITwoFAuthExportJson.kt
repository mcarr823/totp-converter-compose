package dev.mcarr.totpconverter.interfaces.twofauth

import kotlinx.datetime.Instant

interface ITwoFAuthExportJson{
    val app: String
    val schema: Int
    val datetime: Instant
    val data: List<ITwoFAuthExportItem>
}

