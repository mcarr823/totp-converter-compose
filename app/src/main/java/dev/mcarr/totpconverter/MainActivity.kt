package dev.mcarr.totpconverter

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import dev.mcarr.totpconverter.ui.screens.MainActivityScreen
import dev.mcarr.totpconverter.ui.theme.TOTPConverterTheme
import dev.mcarr.totpconverter.viewmodels.MainActivityViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        setContent {
            TOTPConverterTheme {
                val model = MainActivityViewModel()
                MainActivityScreen(model)
            }
        }
    }
}