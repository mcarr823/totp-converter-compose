package dev.mcarr.totpconverter.classes.twofauth

import dev.mcarr.totpconverter.interfaces.twofauth.ITwoFAuthExportJson
import kotlinx.datetime.Instant
import kotlinx.serialization.Serializable

@Serializable
data class TwoFAuthExportJson(
    override val app: String,
    override val schema: Int,
    override val datetime: Instant,
    override val data: List<TwoFAuthExportItem>
) : ITwoFAuthExportJson
