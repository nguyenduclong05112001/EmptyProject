package com.hrk.notes.home.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import com.hrk.notes.home.HomeScreen
import kotlinx.serialization.Serializable

@Serializable
object HomeRoute

fun NavController.navigateToHome(navOptions: NavOptions? = null) =
    navigate(HomeRoute, navOptions)

fun NavGraphBuilder.homeScreen(
    onNextScreen: () -> Unit
) {
    composable<HomeRoute> {
        HomeScreen(
            onCreateNewNote = onNextScreen
        )
    }
}
