package dev.mcarr.totpconverter.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.core.net.toUri
import dev.mcarr.totpconverter.enums.FormatNames
import dev.mcarr.totpconverter.ui.components.Heading
import dev.mcarr.totpconverter.ui.components.PaddedText
import dev.mcarr.totpconverter.ui.components.PreviewComponent
import dev.mcarr.totpconverter.viewmodels.JsonFileViewModel

@Composable
fun ProcessOutputFileScreen(
    paddingValues: PaddingValues,
    model: JsonFileViewModel,
    next: () -> Unit
) {

    val error by remember {
        mutableStateOf(model.error)
    }

    val errorMsg by remember {
        mutableStateOf(model.errorMsg)
    }

    val success by remember {
        mutableStateOf(model.success)
    }

    Column(
        modifier = Modifier.padding(paddingValues),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        if (success) {

            Heading(text = "Success")
            Spacer(modifier = Modifier.height(16.dp))
            PaddedText(text = "File converted successfully")
            Spacer(modifier = Modifier.height(16.dp))
            Button(onClick = next) {
                Text(text = "Next")
            }

        } else if (error) {

            Heading(text = "Error")
            Spacer(modifier = Modifier.height(16.dp))
            PaddedText(text = errorMsg)

        } else {

            Heading(text = "Processing")
            Spacer(modifier = Modifier.height(16.dp))
            PaddedText(text = "Converting the input file...")
            Spacer(modifier = Modifier.height(16.dp))
            CircularProgressIndicator()

        }
    }

    LaunchedEffect(key1 = Unit) {
        model.convertFile()
    }
}

@Preview
@Composable
fun PreviewProcessOutputFileScreen(){

    val paddingValues = PaddingValues(0.dp)
    val model = JsonFileViewModel().apply {
        inputFormat = FormatNames.AEGIS
        outputFormat = FormatNames.BITWARDEN
        uri = "".toUri()
    }

    PreviewComponent {
        ProcessOutputFileScreen(
            paddingValues = paddingValues,
            model = model,
            next = {}
        )
    }

}