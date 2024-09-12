package dev.mcarr.totpconverter.ui.components
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import dev.mcarr.totpconverter.ui.theme.Typography

/**
 * Text component with pre-defined padding.
 *
 * Used to provide uniform padding (and other styling later)
 * to all screens.
 *
 * @param text Text to display
 * */
@Composable
fun PaddedText(
    text: String,
    style: TextStyle = Typography.bodyMedium,
    padLeft: Int = 8,
    padRight: Int = 8,
    padTop: Int = 8,
    padBottom: Int = 8
) {
    Text(
        text = text,
        style = style,
        modifier = Modifier.padding(
            start = padLeft.dp,
            end = padRight.dp,
            top = padTop.dp,
            bottom = padBottom.dp
        )
    )
}

@Preview
@Composable
fun PreviewPaddedText(){
    PreviewComponent {
        PaddedText(text = "Preview")
    }
}