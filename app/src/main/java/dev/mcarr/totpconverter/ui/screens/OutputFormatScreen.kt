package dev.mcarr.totpconverter.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
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
fun OutputFormatScreen(
    paddingValues: PaddingValues,
    model: JsonFileViewModel,
    next: () -> Unit
) {

    val selectFormat: (FormatNames) -> Unit = {
        model.outputFormat = it
        next()
    }

    Column(
        Modifier.padding(paddingValues)
    ) {
        Heading("Step #3: Output Format")
        PaddedText("Export tokens to...")
        Spacer(modifier = Modifier.height(8.dp))

        NavCard("Bitwarden") { selectFormat(FormatNames.BITWARDEN) }
        Spacer(modifier = Modifier.height(8.dp))
        NavCard("2FAuth") { selectFormat(FormatNames.TWOFAUTH) }
        Spacer(modifier = Modifier.height(8.dp))
        NavCard("Aegis") { selectFormat(FormatNames.AEGIS) }
        Spacer(modifier = Modifier.height(8.dp))
        NavCard("Proton", "This option actually exports to Bitwarden format, which Proton Pass is able to import") { selectFormat(FormatNames.PROTON) }

    }

}

@Preview
@Composable
fun PreviewOutputFormatScreen(){

    val paddingValues = PaddingValues(0.dp)
    val model = JsonFileViewModel().apply {
        inputFormat = FormatNames.AEGIS
        uri = "".toUri()
    }
    PreviewComponent {
        OutputFormatScreen(
            paddingValues = paddingValues,
            model = model,
            next = {}
        )
    }
}