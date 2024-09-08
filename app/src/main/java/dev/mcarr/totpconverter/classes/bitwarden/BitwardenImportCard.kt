package dev.mcarr.totpconverter.classes.bitwarden

import dev.mcarr.totpconverter.interfaces.bitwarden.IBitwardenImportCard
import org.json.JSONObject

class BitwardenImportCard : JSONObject(), IBitwardenImportCard {
    override val cardholderName = getString("cardholderName")
    override val brand = null
    override val number = getString("number")
    override val expMonth = getString("expMonth")
    override val expYear = getString("expYear")
    override val code = getString("code")
}