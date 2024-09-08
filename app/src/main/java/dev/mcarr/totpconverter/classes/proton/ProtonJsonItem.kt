package dev.mcarr.totpconverter.classes.proton

import dev.mcarr.totpconverter.classes.GenericJson
import dev.mcarr.totpconverter.classes.GenericJsonEntry
import dev.mcarr.totpconverter.interfaces.proton.IProtonImportData

class ProtonJsonItem(data: IProtonImportData) : GenericJsonEntry() {

    override val type: String = "totp";
    override val name: String;
    override val issuer: String;
    override val secret: String;
    override val algo: String;
    override val digits: Int;
    override val period: Int;
    override val websites: List<String>;

    init {

        val totp = data.content.totpUri
        val args = GenericJson.parseOtpAuthUri(totp);
        val issuerArg = if (args.issuer.isNotEmpty()) args.issuer else data.metadata.name

        this.name = data.content.username
        this.issuer = issuerArg
        this.secret = args.secret
        this.digits = args.digits
        this.algo = args.algo
        this.period = args.period
        this.websites = data.content.urls

    }

}
