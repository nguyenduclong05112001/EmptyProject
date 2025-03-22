package com.hrk.notes.create_note.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import com.hrk.notes.create_note.CreateNoteScreen
import kotlinx.serialization.Serializable

@Serializable
object CreateNoteRoute

fun NavController.navigateToCreateNote(navOptions: NavOptions? = null) =
    navigate(CreateNoteRoute, navOptions)

fun NavGraphBuilder.createNoteScreen(
    navController: NavController,
    onNextScreen: () -> Unit,
) {
    composable<CreateNoteRoute> {
        CreateNoteScreen(
            onBack = navController::popBackStack,
            onPreviewNote = onNextScreen
        )
    }
}
