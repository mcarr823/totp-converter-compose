package dev.mcarr.totpconverter.classes

import android.net.Uri
import dev.mcarr.totpconverter.classes.aegis.AegisExportEntry
import dev.mcarr.totpconverter.classes.aegis.AegisExportEntryInfo
import dev.mcarr.totpconverter.classes.bitwarden.BitwardenExportItem
import dev.mcarr.totpconverter.classes.bitwarden.BitwardenExportItemLogin
import dev.mcarr.totpconverter.classes.bitwarden.BitwardenExportItemLoginUri
import dev.mcarr.totpconverter.classes.twofauth.TwoFAuthExportItem
import dev.mcarr.totpconverter.enums.BitwardenType

abstract class GenericJsonEntry{

    abstract val type: String; // "totp", "steam"
    abstract val name: String; // service name
    abstract val issuer: String;
    abstract val secret: String;
    abstract val algo: String; // eg. "SHA1"
    abstract val digits: Int; // 6 for totp, 5 for steam,
    abstract val period: Int; // usually 30
    abstract val websites: List<String>;

    fun validate(){

        // Name or issuer is required.
        // Otherwise we can't identify which service the token belongs to.
        if (name.isEmpty() && issuer.isEmpty()){
            throw Exception("Name and issuer cannot both be empty");
        }

        // If there's no secret, then it's not a TOTP 2FA token
        if (secret.isEmpty()){
            throw Exception("No secret provided");
        }

        if (algo.isEmpty() || digits <= 0 || period <= 0){
            throw Exception("Invalid token");
        }

    }

    fun buildOtpAuthUri(): String {

        // In theory this shouldn't happen, since the constructor
        // checks for this.
        if (this.issuer.length == 0 && this.name.length == 0){
            throw Exception("Invalid token - issuer or name must be provided");
        }else if (this.secret.length == 0){
            throw Exception("Invalid token - secret must be provided");
        }else if (this.algo.length == 0 || this.digits <= 0 || this.period <= 0){
            throw Exception("Invalid token");
        }

        val params = Uri.Builder()
            .scheme("otpauth")
            .appendPath("totp")
            .appendQueryParameter("secret", secret)
            .appendQueryParameter("algorithm", algo)
            .appendQueryParameter("digits", digits.toString())
            .appendQueryParameter("period", period.toString())
        val serviceNameArr = arrayListOf<String>();

        if (this.issuer.length > 0){
            serviceNameArr.add(this.issuer);
            params.appendQueryParameter("issuer", issuer)
        }

        if (this.name.length > 0){
            serviceNameArr.add(this.name);
        }

        // eg. Facebook:myaccountname
        params.appendEncodedPath(serviceNameArr.joinToString(":"))

        return params.build().toString()

    }

    fun exportAegis() : AegisExportEntry =
        AegisExportEntry(
            type = type,
            name = name,
            issuer = issuer,
            info = AegisExportEntryInfo(
                secret = secret,
                algo = algo,
                digits = digits,
                period = period
            )
        )

    fun exportBitwarden(): BitwardenExportItem {
        if (type != "totp"){
            throw Exception("Bitwarden does not support this type of token")
        }
        val uris =
            websites.map {
                BitwardenExportItemLoginUri(
                    match = null,
                    uri = it
                )
            }
        return BitwardenExportItem(
            type = BitwardenType.LOGIN.value,
            name = issuer,
            login = BitwardenExportItemLogin(
                totp = buildOtpAuthUri(),
                uris = uris
            )
        )
    }

    fun exportTwoFAuth() : TwoFAuthExportItem =
        TwoFAuthExportItem(
            otp_type = type,
            account = name,
            service = issuer,
            secret = secret,
            digits = digits,
            algorithm = algo,
            period = period,
            counter = null,
            legacy_uri = buildOtpAuthUri()
        )

}