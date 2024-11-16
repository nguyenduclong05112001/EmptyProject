package com.hrk.base.other.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import com.hrk.base.other.OtherScreen
import kotlinx.serialization.Serializable

@Serializable
object OtherRoute

fun NavController.navigateToOther(navOptions: NavOptions? = null) =
    navigate(OtherRoute, navOptions)

fun NavGraphBuilder.otherScreen(
    onNextScreen: () -> Unit,
) {
    composable<OtherRoute> {
        OtherScreen(
            onNextScreen = onNextScreen
        )
    }
}
