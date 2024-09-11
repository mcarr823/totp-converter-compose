package dev.mcarr.totpconverter.classes.twofauth

import dev.mcarr.totpconverter.interfaces.twofauth.ITwoFAuthImportJson
import kotlinx.datetime.Instant
import kotlinx.serialization.Serializable

@Serializable
data class TwoFAuthImportJson(
    override val app: String,
    override val schema: Int,
    override val datetime: Instant,
    override val data: List<TwoFAuthImportToken>
) : ITwoFAuthImportJson