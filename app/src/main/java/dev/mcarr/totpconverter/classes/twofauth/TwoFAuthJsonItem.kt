package dev.mcarr.totpconverter.classes.twofauth

import dev.mcarr.totpconverter.classes.GenericJson
import dev.mcarr.totpconverter.classes.GenericJsonEntry
import dev.mcarr.totpconverter.interfaces.IGenericJsonEntry
import dev.mcarr.totpconverter.interfaces.twofauth.ITwoFAuthImportToken

class TwoFAuthJsonItem : GenericJsonEntry {

    override val type: String;
    override val name: String;
    override val issuer: String;
    override val secret: String;
    override val algo: String;
    override val digits: Int;
    override val period: Int;
    override val websites = listOf<String>()

    constructor(
        data: ITwoFAuthImportToken
    ){

        val parsedArgs = GenericJson.parseOtpAuthUri(data.legacy_uri);
        val pair = this.parseIssuer(data, parsedArgs.issuer, parsedArgs.name)

        this.type = data.otp_type
        this.name = pair.second
        this.issuer = pair.first
        this.secret = data.secret
        this.algo = data.algorithm
        this.digits = data.digits
        this.period = data.period

    }

    fun parseIssuer(
        data: ITwoFAuthImportToken,
        issuer: String,
        name: String
    ): Pair<String, String> {
        val srv = data.service
        val issuerArg: String
        val nameArg: String
        if (issuer.isNotEmpty() && name.isNotEmpty()){
            issuerArg = issuer;
            nameArg = name;
        }else if (issuer.length > 0){
            issuerArg = issuer;
            nameArg = data.account;
        }else if (srv != null){
            issuerArg = srv;
            nameArg = data.account;
        }else{
            issuerArg = data.account;
            nameArg = ""
        }
        return issuerArg to nameArg
    }

}