package dev.mcarr.totpconverter.classes.bitwarden

import dev.mcarr.totpconverter.interfaces.bitwarden.IBitwardenImportIdentity
import kotlinx.serialization.Serializable

@Serializable
data class BitwardenImportIdentity(
    override val title: String?,
    override val firstName: String?,
    override val middleName: String?,
    override val lastName: String?,
    override val address1: String?,
    override val address2: String?,
    override val address3: String?,
    override val city: String?,
    override val state: String?,
    override val postalCode: String?,
    override val country: String?,
    override val company: String?,
    override val email: String?,
    override val phone: String?,
    override val ssn: String?,
    override val username: String?,
    override val passportInt: String?,
    override val licenseInt: String?
) : IBitwardenImportIdentity