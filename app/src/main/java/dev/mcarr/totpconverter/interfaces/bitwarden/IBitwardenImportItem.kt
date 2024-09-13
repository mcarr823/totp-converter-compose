package dev.mcarr.totpconverter.interfaces.bitwarden

import kotlinx.datetime.Instant

interface IBitwardenImportItem{
    val passwordHistory: List<IBitwardenImportPasswordHistory>?;
    val revisionDate: Instant?;
    val creationDate: Instant?;
    val deletedDate: Instant?;
    val id: String?;
    val organizationId: String?;
    val folderId: String?;
    val type: Int;
    val reprompt: Int?;
    val name: String;
    val notes: String?;
    val favorite: Boolean?;
    val secureNote: IBitwardenImportSecureNote?;
    val card: IBitwardenImportCard?;
    val fields: List<IBitwardenImportField>?;
    val login: IBitwardenImportLogin?;
    val identity: IBitwardenImportIdentity?;
    val collectionIds: String?;
}