package dev.mcarr.totpconverter.ui.screens

import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.core.net.toUri
import dev.mcarr.totpconverter.enums.FormatNames
import dev.mcarr.totpconverter.ui.components.Heading
import dev.mcarr.totpconverter.ui.components.PaddedText
import dev.mcarr.totpconverter.ui.components.PreviewComponent
import dev.mcarr.totpconverter.viewmodels.JsonFileViewModel

@Composable
fun ResultScreen(
    paddingValues: PaddingValues,
    model: JsonFileViewModel,
) {

    val c = LocalContext.current

    val launcher = rememberLauncherForActivityResult(ActivityResultContracts.CreateDocument("text/json")) {
        it?.let(model::writeFile)
    }

    val download = {
        model.reinit()
        val suggestedFileName = when(model.outputFormat){
            FormatNames.AEGIS -> "totp_export_aegis.json"
            FormatNames.PROTON -> "totp_export_proton.json"
            FormatNames.BITWARDEN -> "totp_export_bitwarden.json"
            FormatNames.TWOFAUTH -> "totp_export_2fauth.json"
        }
        launcher.launch(suggestedFileName)
    }

    val send = {
        model.reinit()
        model.sendFile(c)
    }

    Column(
        modifier = Modifier.padding(paddingValues),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Heading(text = "Finished")
        Spacer(modifier = Modifier.height(16.dp))
        PaddedText(text = "Download your converted file to use with your new 2FA provider.")
        Spacer(modifier = Modifier.height(16.dp))
        Button(onClick = download) {
            Text(text = "Download")
        }
        Button(onClick = send) {
            Text(text = "Send")
        }

    }

}

@Preview
@Composable
fun PreviewResultScreenLight(){

    val paddingValues = PaddingValues(0.dp)
    val model = JsonFileViewModel().apply {
        inputFormat = FormatNames.AEGIS
        outputFormat = FormatNames.BITWARDEN
        uri = "".toUri()
    }

    PreviewComponent {
        ResultScreen(
            paddingValues = paddingValues,
            model = model
        )
    }

}

@Preview
@Composable
fun PreviewResultScreenDark(){

    val paddingValues = PaddingValues(0.dp)
    val model = JsonFileViewModel().apply {
        inputFormat = FormatNames.AEGIS
        outputFormat = FormatNames.BITWARDEN
        uri = "".toUri()
    }

    PreviewComponent(
        darkMode = true
    ) {
        ResultScreen(
            paddingValues = paddingValues,
            model = model
        )
    }

}