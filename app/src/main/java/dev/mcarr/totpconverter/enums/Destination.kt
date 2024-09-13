package dev.mcarr.totpconverter.enums

/**
 * Enum used to identify each individual composable route
 * in the app.
 *
 * These values are used to identify individual screens
 * or components, and to navigate between them from the
 * NavGraph in MainActivity.
 *
 * @param route Navigation route which this destination
 * maps to.
 *
 * @see dev.mcarr.totpconverter.ui.screens.MainActivityScreen
 * */
enum class Destination(
    val route: String
){
    INPUT_FORMAT("INPUT_FORMAT"),
    INPUT_FILE("INPUT_FILE"),
    INPUT_PROCESSING("INPUT_PROCESSING"),
    OUTPUT_FORMAT("OUTPUT_FORMAT"),
    OUTPUT_PROCESSING("OUTPUT_PROCESSING"),
    RESULT("RESULT"),
    ABOUT("ABOUT")
}