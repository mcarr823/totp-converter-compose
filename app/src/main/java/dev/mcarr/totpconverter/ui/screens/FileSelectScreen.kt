package dev.mcarr.totpconverter.ui.screens

import android.net.Uri
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.core.net.toUri
import dev.mcarr.totpconverter.enums.FormatNames
import dev.mcarr.totpconverter.ui.components.Heading
import dev.mcarr.totpconverter.ui.components.NavCard
import dev.mcarr.totpconverter.ui.components.PaddedText
import dev.mcarr.totpconverter.ui.components.PreviewComponent
import dev.mcarr.totpconverter.viewmodels.JsonFileViewModel

@Composable
fun FileSelectScreen(
    paddingValues: PaddingValues,
    model: JsonFileViewModel,
    next: () -> Unit
) {

    val name = remember {
        model.inputFormat.value
    }

    val launcher = rememberLauncherForActivityResult(ActivityResultContracts.OpenDocument()) {
        if (it != null){
            model.uri = it
            next()
        }
    }

    Column(
        Modifier.padding(paddingValues)
    ) {
        Heading("Step #2: Input File")
        PaddedText("Select $name file to convert")
        Spacer(modifier = Modifier.height(8.dp))

        Button(
            onClick = {
                launcher.launch(arrayOf("text/json"))
            },
        ) {
            Text(text = "Select File")
        }
    }

}

@Preview
@Composable
fun PreviewFileSelectScreen(){

    val paddingValues = PaddingValues(0.dp)
    val model = JsonFileViewModel().apply {
        inputFormat = FormatNames.AEGIS
        uri = "".toUri()
    }

    PreviewComponent {
        FileSelectScreen(
            paddingValues = paddingValues,
            model = model,
            next = {}
        )
    }
}

@Preview
@Composable
fun PreviewFileSelectScreenDark(){

    val paddingValues = PaddingValues(0.dp)
    val model = JsonFileViewModel().apply {
        inputFormat = FormatNames.AEGIS
        uri = "".toUri()
    }

    PreviewComponent(
        darkMode = true
    ) {
        FileSelectScreen(
            paddingValues = paddingValues,
            model = model,
            next = {}
        )
    }
}