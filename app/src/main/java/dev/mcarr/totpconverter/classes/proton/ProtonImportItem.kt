package dev.mcarr.totpconverter.classes.proton

import dev.mcarr.totpconverter.interfaces.proton.IProtonImportItem
import kotlinx.serialization.Serializable

@Serializable
data class ProtonImportItem(
    override val data: ProtonImportData,
    override val itemId: String,
    override val shareId: String,
    override val state: Int,
    override val aliasEmail: String?,
    override val contentFormatVersion: Int,
    override val createTime: Long,
    override val modifyTime: Long,
    override val pinned: Boolean
) : IProtonImportItem