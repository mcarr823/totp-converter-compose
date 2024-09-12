package dev.mcarr.totpconverter.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowForward
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedCard
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import dev.mcarr.totpconverter.ui.theme.Typography

/**
 * Clickable card component with text inside of it.
 *
 * @param text Larger text to display at the top of the card
 * @param subtext Smaller text to display below the main text
 * @param onClick Callback to invoke when the card is tapped
 * */
@Composable
fun NavCard(
    text: String,
    subtext: String = "",
    onClick: () -> Unit
) {
    OutlinedCard(
        onClick = onClick,
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 4.dp, end = 4.dp)
    ) {
        Column {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                PaddedText(
                    text = text,
                    style = Typography.bodyLarge,
                    padBottom = 0
                )
                Icon(
                    imageVector = Icons.AutoMirrored.Default.ArrowForward,
                    contentDescription = "Right arrow",
                    modifier = Modifier.padding(8.dp)
                )
            }
            PaddedText(
                text = subtext,
                style = Typography.labelSmall,
                padTop = 0
            )
        }
    }
}

@Preview
@Composable
fun PreviewNavCardLight(){
    PreviewComponent {
        NavCard(text = "Text with heading only") {}
        NavCard(text = "Text with subtext", "Subtext") {}
    }
}

@Preview
@Composable
fun PreviewNavCardDark(){
    PreviewComponent(
        darkMode = true
    ) {
        NavCard(text = "Text with heading only") {}
        NavCard(text = "Text with subtext", "Subtext") {}
    }
}