package dev.mcarr.totpconverter.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
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
fun InputFormatScreen(
    paddingValues: PaddingValues,
    model: JsonFileViewModel,
    next: () -> Unit
) {

    val selectFormat: (FormatNames) -> Unit = {
        model.inputFormat = it
        next()
    }

    Column {
        Heading("Step #1: Input Format")
        PaddedText("Select the type of 2FA data you want to convert from")
        Spacer(modifier = Modifier.height(8.dp))

        NavCard("Bitwarden") { selectFormat(FormatNames.BITWARDEN) }
        Spacer(modifier = Modifier.height(8.dp))
        NavCard("2FAuth") { selectFormat(FormatNames.TWOFAUTH) }
        Spacer(modifier = Modifier.height(8.dp))
        NavCard("Aegis") { selectFormat(FormatNames.AEGIS) }
        Spacer(modifier = Modifier.height(8.dp))
        NavCard("Proton") { selectFormat(FormatNames.PROTON) }

    }

}

@Preview
@Composable
fun PreviewInputFormatScreen(){

    val paddingValues = PaddingValues(0.dp)
    val model = JsonFileViewModel().apply {
        inputFormat = FormatNames.AEGIS
        uri = "".toUri()
    }
    PreviewComponent {
        InputFormatScreen(
            paddingValues = paddingValues,
            model = model,
            next = {}
        )
    }
}

@Preview
@Composable
fun PreviewInputFormatScreenDark(){

    val paddingValues = PaddingValues(0.dp)
    val model = JsonFileViewModel().apply {
        inputFormat = FormatNames.AEGIS
        uri = "".toUri()
    }
    PreviewComponent(
        darkMode = true
    ) {
        InputFormatScreen(
            paddingValues = paddingValues,
            model = model,
            next = {}
        )
    }
}