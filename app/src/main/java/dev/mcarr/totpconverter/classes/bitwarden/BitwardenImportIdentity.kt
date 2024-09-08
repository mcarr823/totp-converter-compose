package dev.mcarr.totpconverter.classes.bitwarden

import dev.mcarr.totpconverter.interfaces.bitwarden.IBitwardenImportIdentity
import org.json.JSONObject

class BitwardenImportIdentity : JSONObject(), IBitwardenImportIdentity {
    override val title = getString("title")
    override val firstName = getString("firstName")
    override val middleName = getString("middleName")
    override val lastName = getString("lastName")
    override val address1 = getString("address1")
    override val address2 = null
    override val address3 = null
    override val city = getString("city")
    override val state = getString("state")
    override val postalCode = getString("postalCode")
    override val country = getString("country")
    override val company = getString("company")
    override val email = getString("email")
    override val phone = getString("phone")
    override val ssn = getString("ssn")
    override val username = getString("username")
    override val passportInt = getString("passportInt")
    override val licenseInt = getString("licenseInt")
}