/*
 * Copyright 2022 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.hrk.apps.hrkdev.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import com.hrk.apps.hrkdev.ui.HRKAppState
import com.hrk.base.home.navigation.HomeRoute
import com.hrk.base.home.navigation.homeScreen
import com.hrk.base.home.navigation.navigateToHome
import com.hrk.base.other.navigation.navigateToOther
import com.hrk.base.other.navigation.otherScreen
import com.hrk.base.setting.navigation.navigateToSetting
import com.hrk.base.setting.navigation.settingScreen

/**
 * Top-level navigation graph. Navigation is organized as explained at
 * https://d.android.com/jetpack/compose/nav-adaptive
 *
 * The navigation graph defined in this file defines the different top level routes. Navigation
 * within each route is handled using state and Back Handlers.
 */
@Composable
fun HRKNavHost(
    appState: HRKAppState,
    onShowSnackbar: suspend (String, String?) -> Boolean,
    modifier: Modifier = Modifier,
) {
    val navController = appState.navController
    NavHost(
        navController = navController,
        startDestination = HomeRoute,
        modifier = modifier,
    ) {
        homeScreen(
            onNextScreen = navController::navigateToOther,
        )
        otherScreen(
            onNextScreen = navController::navigateToSetting,
        )
        settingScreen(
            onNextScreen = navController::navigateToHome,
        )
    }
}
