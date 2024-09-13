package dev.mcarr.totpconverter.ui.screens

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import dev.mcarr.totpconverter.enums.Destination
import dev.mcarr.totpconverter.enums.Destination.ABOUT
import dev.mcarr.totpconverter.enums.Destination.INPUT_FILE
import dev.mcarr.totpconverter.enums.Destination.INPUT_FORMAT
import dev.mcarr.totpconverter.enums.Destination.INPUT_PROCESSING
import dev.mcarr.totpconverter.enums.Destination.OUTPUT_FORMAT
import dev.mcarr.totpconverter.enums.Destination.OUTPUT_PROCESSING
import dev.mcarr.totpconverter.enums.Destination.RESULT
import dev.mcarr.totpconverter.ui.components.PreviewComponent
import dev.mcarr.totpconverter.viewmodels.JsonFileViewModel
import dev.mcarr.totpconverter.viewmodels.MainActivityViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainActivityScreen(
    activityModel: MainActivityViewModel
) {

    val model = JsonFileViewModel()

    var route by remember {
        activityModel.route
    }

    val navController = rememberNavController()
    navController.addOnDestinationChangedListener { _, destination, _ ->
        route = destination.route ?: ""
    }

    val goTo: (destination: Destination) -> Unit = { destination ->
        navController.navigate(destination.route)
    }

    val goBack: () -> Unit = {
        if (route == OUTPUT_FORMAT.route){
            navController.popBackStack(INPUT_FILE, false)
        }else if (route == RESULT.route){
            navController.popBackStack(OUTPUT_FORMAT, false)
        }else{
            navController.popBackStack()
        }
    }

    Scaffold(
        modifier = Modifier.fillMaxSize(),
        topBar = {
            TopAppBar(
                title = {},
                navigationIcon = {
                    if (route == INPUT_FORMAT.route) {
                        TextButton(
                            onClick = { goTo(ABOUT) }
                        ) {
                            Text("About")
                        }
                    } else {
                        IconButton(
                            onClick = { goBack() },
                            content = { Icon(Icons.AutoMirrored.Default.ArrowBack, "") }
                        )
                    }
                }
            )
        }
    ) { p ->

        NavHost(
            navController = navController,
            startDestination = activityModel.startDestination
        ) {

            composable(ABOUT.route){
                AboutScreen(p)
            }
            composable(INPUT_FORMAT.route){
                InputFormatScreen(p, model) { goTo(INPUT_FILE) }
            }
            composable(INPUT_FILE.route){
                FileSelectScreen(p, model) { goTo(INPUT_PROCESSING) }
            }
            composable(INPUT_PROCESSING.route){
                ProcessInputFileScreen(p, model) { goTo(OUTPUT_FORMAT) }
            }
            composable(OUTPUT_FORMAT.route){
                OutputFormatScreen(p, model) { goTo(OUTPUT_PROCESSING) }
            }
            composable(OUTPUT_PROCESSING.route){
                ProcessOutputFileScreen(p, model) { goTo(RESULT) }
            }
            composable(RESULT.route){
                ResultScreen(p, model)
            }

        }
    }

}

@Preview(showBackground = true)
@Composable
fun MainActivityInputFormatPreview() {
    PreviewComponent {
        val model = MainActivityViewModel()
        // Defaults to INPUT_FORMAT
        MainActivityScreen(model)
    }
}

@Preview(showBackground = true)
@Composable
fun MainActivityInputFilePreview() {
    PreviewComponent {
        val model = MainActivityViewModel()
        model.startDestination = INPUT_FILE
        MainActivityScreen(model)
    }
}

@Preview(showBackground = true)
@Composable
fun MainActivityInputProcessingPreview() {
    PreviewComponent {
        val model = MainActivityViewModel()
        model.startDestination = INPUT_PROCESSING
        MainActivityScreen(model)
    }
}

@Preview(showBackground = true)
@Composable
fun MainActivityOutputFormatPreview() {
    PreviewComponent {
        val model = MainActivityViewModel()
        model.startDestination = OUTPUT_FORMAT
        MainActivityScreen(model)
    }
}

@Preview(showBackground = true)
@Composable
fun MainActivityOutputProcessingPreview() {
    PreviewComponent {
        val model = MainActivityViewModel()
        model.startDestination = OUTPUT_PROCESSING
        MainActivityScreen(model)
    }
}

@Preview(showBackground = true)
@Composable
fun MainActivityResultPreview() {
    PreviewComponent {
        val model = MainActivityViewModel()
        model.startDestination = RESULT
        MainActivityScreen(model)
    }
}