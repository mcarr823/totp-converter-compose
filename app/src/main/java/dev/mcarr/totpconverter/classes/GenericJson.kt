package dev.mcarr.totpconverter.classes

import android.net.Uri
import androidx.core.net.toUri
import dev.mcarr.totpconverter.classes.aegis.AegisJson
import dev.mcarr.totpconverter.classes.bitwarden.BitwardenJson
import dev.mcarr.totpconverter.classes.proton.ProtonJson
import dev.mcarr.totpconverter.classes.twofauth.TwoFAuthJson
import dev.mcarr.totpconverter.enums.FormatNames
import dev.mcarr.totpconverter.interfaces.bitwarden.IBitwardenImportJson
import dev.mcarr.totpconverter.interfaces.IGenericJsonEntry
import dev.mcarr.totpconverter.interfaces.twofauth.ITwoFAuthImportJson
import org.json.JSONObject

class GenericJson(
    val entries: List<GenericJsonEntry>
){

    fun export(format: FormatNames): JSONObject =
        when(format) {
            FormatNames.AEGIS -> AegisJson.export(entries)
            FormatNames.BITWARDEN -> BitwardenJson.export(entries)
            FormatNames.TWOFAUTH -> TwoFAuthJson.export(entries)
            else -> throw Exception("Export failed")
        }

    companion object{

        fun parse(str: String, format: FormatNames): GenericJson {
            val json = JSONObject(str)
            return when (format){
                FormatNames.AEGIS -> AegisJson.import(json)
                FormatNames.PROTON -> ProtonJson.import(json)
                FormatNames.BITWARDEN -> BitwardenJson.import(json)
                FormatNames.TWOFAUTH -> TwoFAuthJson.import(json)
            }
        }

        fun parseOtpAuthUri(uriString: String) : GenericJsonTotpArgs {

            val uri = uriString.toUri()
            val pathSegments = uri.pathSegments
            val queryParameterNames = uri.queryParameterNames

            val digits = 6;
            val period = 30;
            val algo = "sha1";
            val name = "";
            val issuer = "";

            if (uri.scheme != "optauth" || pathSegments[0] != "totp"){
                val secret = "";
                GenericJsonTotpArgs(
                    name = name,
                    issuer = issuer,
                    secret = secret,
                    algo = algo,
                    digits = digits,
                    period = period
                )
            }

            // First, test for otpauth uris without any parameters.
            // eg. otpauth://totp/mysecret
            if (queryParameterNames.isEmpty()){
                val secret = pathSegments[1] // TODO throw exception if it doesn't exist?
                GenericJsonTotpArgs(
                    name = name,
                    issuer = issuer,
                    secret = secret,
                    algo = algo,
                    digits = digits,
                    period = period
                )
            }

            // If the uri DOES have parameters, parse them as a
            // URLSearchParams object.
            // eg. otpauth://totp/Facebook:myusername?issuer=Facebook&secret=abc
            return parseOtpAuthUriWithSearchParams(
                uri,
                digits,
                period,
                algo
            )

        }

        fun parseOtpAuthUriWithSearchParams(
            uri: Uri,
            defaultDigits: Int,
            defaultPeriod: Int,
            defaultAlgo: String
        ): GenericJsonTotpArgs {

            // eg. otpauth://totp/Facebook:myusername?issuer=Facebook&secret=abc
            val nameAndIssuer = uri.pathSegments[1]
            val decodedNameAndIssuer = nameAndIssuer // TODO does it need to be decoded?
            val cIndex = decodedNameAndIssuer.indexOf(':')

            val defaultIssuer: String
            val name: String
            if (cIndex != -1){
                defaultIssuer = decodedNameAndIssuer.substring(0, cIndex)
                name = decodedNameAndIssuer.substring(cIndex+1)
            }else{
                defaultIssuer = decodedNameAndIssuer
                name = ""
            }

            val digitParam = uri.getQueryParameter("digits");
            val periodParam = uri.getQueryParameter("period");
            val secret = uri.getQueryParameter("secret") ?: ""
            val digits = digitParam?.toIntOrNull() ?: defaultDigits
            val period = periodParam?.toIntOrNull() ?: defaultPeriod
            val algo = uri.getQueryParameter("algorithm") ?: defaultAlgo
            val issuer = uri.getQueryParameter("issuer") ?: defaultIssuer

            return GenericJsonTotpArgs(
                secret = secret,
                digits = digits,
                period = period,
                algo = algo,
                issuer = issuer,
                name = name
            )

        }
    }

}
