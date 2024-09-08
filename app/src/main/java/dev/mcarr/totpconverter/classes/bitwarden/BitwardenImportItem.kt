package dev.mcarr.totpconverter.classes.bitwarden

import dev.mcarr.totpconverter.interfaces.bitwarden.IBitwardenImportItem
import dev.mcarr.totpconverter.utilities.mapJsonArray
import org.json.JSONObject

class BitwardenImportItem : JSONObject(), IBitwardenImportItem {
    override val passwordHistory = null
    override val revisionDate = getString("revisionDate")
    override val creationDate = getString("creationDate")
    override val deletedDate = null
    override val id = getString("id")
    override val organizationId = null
    override val folderId = null
    override val type = getInt("type")
    override val reprompt = getInt("reprompt")
    override val name = getString("name")
    override val notes = getString("notes")
    override val favorite = getBoolean("favorite")
    override val secureNote = null
    override val card = null
    override val fields = mapJsonArray<BitwardenImportField>("fields")
    override val login = null
    override val identity = null
    override val collectionIds = null
}