package dev.mcarr.totpconverter.classes.bitwarden

import dev.mcarr.totpconverter.interfaces.bitwarden.IBitwardenImportItem
import kotlinx.datetime.Instant
import kotlinx.serialization.Serializable

@Serializable
data class BitwardenImportItem(
    override val passwordHistory: List<BitwardenImportPasswordHistory>?,
    override val revisionDate: Instant?,
    override val creationDate: Instant?,
    override val deletedDate: Instant?,
    override val id: String?,
    override val organizationId: String?,
    override val folderId: String?,
    override val type: Int,
    override val reprompt: Int?,
    override val name: String,
    override val notes: String?,
    override val favorite: Boolean?,
    override val secureNote: BitwardenImportSecureNote?,
    override val card: BitwardenImportCard?,
    override val fields: List<BitwardenImportField>?,
    override val login: BitwardenImportLogin?,
    override val identity: BitwardenImportIdentity?,
    override val collectionIds: String?
) : IBitwardenImportItem