package com.hrk.apps.hrkdev.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import com.hrk.apps.hrkdev.ui.HRKAppState
import com.hrk.notes.create_note.navigation.createNoteScreen
import com.hrk.notes.create_note.navigation.navigateToCreateNote
import com.hrk.notes.home.navigation.HomeRoute
import com.hrk.notes.home.navigation.homeScreen
import com.hrk.notes.home.navigation.navigateToHome
import com.hrk.notes.setting.navigation.navigateToSetting
import com.hrk.notes.setting.navigation.settingScreen

@Composable
fun HRKNavHost(
    modifier: Modifier,
    appState: HRKAppState,
) {
    val navController = appState.navController
    NavHost(
        modifier = modifier,
        navController = navController,
        startDestination = HomeRoute,
    ) {
        homeScreen(
            onNextScreen = navController::navigateToCreateNote,
        )
        createNoteScreen(
            navController = navController,
            onNextScreen = navController::navigateToSetting,
        )
        settingScreen(
            onNextScreen = navController::navigateToHome,
        )
    }
}
