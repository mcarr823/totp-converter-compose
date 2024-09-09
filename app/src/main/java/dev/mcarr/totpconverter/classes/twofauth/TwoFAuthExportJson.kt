package dev.mcarr.totpconverter.classes.twofauth

import dev.mcarr.totpconverter.interfaces.twofauth.ITwoFAuthExportJson
import kotlinx.serialization.Serializable

@Serializable
data class TwoFAuthExportJson(
    override val data: List<TwoFAuthExportItem>
) : ITwoFAuthExportJson
