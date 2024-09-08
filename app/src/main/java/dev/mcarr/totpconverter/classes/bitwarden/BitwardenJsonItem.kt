package dev.mcarr.totpconverter.classes.bitwarden

import dev.mcarr.totpconverter.classes.GenericJson
import dev.mcarr.totpconverter.classes.GenericJsonEntry
import dev.mcarr.totpconverter.interfaces.bitwarden.IBitwardenImportItem

class BitwardenJsonItem(data: IBitwardenImportItem) : GenericJsonEntry() {

    override val type: String;
    override val name: String;
    override val issuer: String;
    override val secret: String;
    override val algo: String;
    override val digits: Int;
    override val period: Int;
    override val websites: List<String>;

    init {

        val login = data.login ?: throw Exception("No login node - Not a valid 2FA token")
        val totp = login.totp ?: throw Exception("TOTP cannot be null")

        val args = GenericJson.parseOtpAuthUri(totp);
        val (issuer, name) = this.parseIssuer(data, args.issuer, args.name)

        this.type = "totp"
        this.name = name
        this.issuer = issuer
        this.secret = args.secret
        this.algo = args.algo
        this.digits = args.digits
        this.period = args.period
        this.websites = login.uris.map{ it.uri }

    }

    fun parseIssuer(
        data: IBitwardenImportItem,
        issuer: String,
        name: String
    ): Pair<String, String> = when {
        issuer.isNotEmpty() && name.isNotEmpty() -> issuer to name
        issuer.isNotEmpty() -> issuer to data.name
        else -> data.name to ""
    }
    // TODO parse username?

}