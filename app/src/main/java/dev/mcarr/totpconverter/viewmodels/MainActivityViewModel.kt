package dev.mcarr.totpconverter.viewmodels

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import dev.mcarr.totpconverter.enums.Destination

/**
 * Viewmodel for MainActivity.
 *
 * @see dev.mcarr.totpconverter.MainActivity
 * @see dev.mcarr.totpconverter.ui.screens.MainActivityScreen
 * */
class MainActivityViewModel : ViewModel() {

    /**
     * The current route.
     *
     * Used to keep track of which screen we're currently
     * viewing, for the sake of altering other parts of
     * the UI.
     *
     * eg. To hide the "back" navigation, or to show
     * different actions in the action bar.
     * */
    var route = mutableStateOf("")

    /**
     * Start destination for the NavGraph.
     *
     * This value should ONLY be changed for unit testing
     * or preview purposes.
     * */
    var startDestination = Destination.INPUT_FORMAT.route

}