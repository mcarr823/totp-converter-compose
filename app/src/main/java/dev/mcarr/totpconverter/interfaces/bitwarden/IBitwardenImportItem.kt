package dev.mcarr.totpconverter.interfaces.bitwarden

interface IBitwardenImportItem{
    val passwordHistory: Any?;
    val revisionDate: String;
    val creationDate: String;
    val deletedDate: Any?;
    val id: String;
    val organizationId: Any?;
    val folderId: Any?;
    val type: Int;
    val reprompt: Int;
    val name: String;
    val notes: String;
    val favorite: Boolean;
    val secureNote: IBitwardenImportSecureNote?;
    val card: IBitwardenImportCard?;
    val fields: List<IBitwardenImportField>;
    val login: IBitwardenImportLogin?;
    val identity: IBitwardenImportIdentity?;
    val collectionIds: Any?;
}