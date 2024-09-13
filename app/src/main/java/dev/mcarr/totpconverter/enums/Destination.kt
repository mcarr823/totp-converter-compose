package dev.mcarr.totpconverter.enums

/**
 * Object which contains String keys for each individual
 * composable route in the app.
 *
 * These values are used to identify individual screens
 * or components, and to navigate between them from the
 * NavGraph in MainActivity.
 *
 * @see dev.mcarr.totpconverter.MainActivity
 * */
object Destination{
    const val INPUT_FORMAT = "INPUT_FORMAT"
    const val INPUT_FILE = "INPUT_FILE"
    const val INPUT_PROCESSING = "INPUT_PROCESSING"
    const val OUTPUT_FORMAT = "OUTPUT_FORMAT"
    const val OUTPUT_PROCESSING = "OUTPUT_PROCESSING"
    const val RESULT = "RESULT"
    const val ABOUT = "ABOUT"
}