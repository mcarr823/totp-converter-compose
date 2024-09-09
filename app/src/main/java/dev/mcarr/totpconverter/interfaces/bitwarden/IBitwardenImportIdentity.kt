package dev.mcarr.totpconverter.interfaces.bitwarden

interface IBitwardenImportIdentity{
    val title: String?
    val firstName: String?
    val middleName: String?
    val lastName: String?
    val address1: String?
    val address2: String?
    val address3: String?
    val city: String?
    val state: String?
    val postalCode: String?
    val country: String?
    val company: String?
    val email: String?
    val phone: String?
    val ssn: String?
    val username: String?
    val passportInt: String?
    val licenseInt: String?
}