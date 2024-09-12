package dev.mcarr.totpconverter.viewmodels

import android.content.Context
import android.content.Intent
import android.net.Uri
import androidx.core.net.toFile
import androidx.lifecycle.ViewModel
import dev.mcarr.totpconverter.classes.GenericJson
import dev.mcarr.totpconverter.classes.aegis.AegisJson
import dev.mcarr.totpconverter.classes.bitwarden.BitwardenJson
import dev.mcarr.totpconverter.classes.proton.ProtonJson
import dev.mcarr.totpconverter.classes.twofauth.TwoFAuthJson
import dev.mcarr.totpconverter.enums.Destination
import dev.mcarr.totpconverter.enums.FormatNames

class JsonFileViewModel : ViewModel() {

    lateinit var uri: Uri
    lateinit var inputFormat: FormatNames
    lateinit var outputFormat: FormatNames
    lateinit var genericJson: GenericJson

    var error = false
    var errorMsg = ""
    var success = false
    var numberParsed = 0
    var exportedJsonString = ""
    var route = ""
    var startDestination = Destination.INPUT_FORMAT

    fun reinit(){
        error = false
        errorMsg = ""
        success = false
        numberParsed = 0
    }

    fun parseFile(){
        try {
            val f = uri.toFile()
            if (f.extension.lowercase() != "json"){
                errorMsg = "Invalid format. Must be a JSON file"
                error = true
            }else{
                val str = f.readText()
                genericJson = when(inputFormat){
                    FormatNames.PROTON -> ProtonJson.import(str)
                    FormatNames.AEGIS -> AegisJson.import(str)
                    FormatNames.BITWARDEN -> BitwardenJson.import(str)
                    FormatNames.TWOFAUTH -> TwoFAuthJson.import(str)
                }
                numberParsed = genericJson.entries.size
                if (numberParsed > 0) {
                    success = true
                }else{
                    errorMsg = "Failed to find any tokens to import"
                    error = true
                }
            }
        }catch (e: Exception){
            errorMsg = "Failed to read input file"
            error = true
        }
    }

    fun convertFile(){
        try {
            exportedJsonString = genericJson.export(outputFormat)
            if (exportedJsonString.isNotEmpty()) {
                success = true
            }else{
                errorMsg = "Export file was empty"
                error = true
            }
        }catch (e: Exception){
            errorMsg = "Failed to convert file"
            error = true
        }
    }

    fun sendFile(c: Context){
        val sendIntent: Intent = Intent().apply {
            action = Intent.ACTION_SEND
            putExtra(Intent.EXTRA_TEXT, "This is my text to send.")
            type = "text/json"
        }
        val shareIntent = Intent.createChooser(sendIntent, null)
        c.startActivity(shareIntent)

    }

    fun writeFile(uri: Uri){
        try {
            uri.toFile().writeText(exportedJsonString)
        }catch (e: Exception){
            e.printStackTrace()
            errorMsg = "Failed to save file. Permission denied"
            error = true
        }
    }

}