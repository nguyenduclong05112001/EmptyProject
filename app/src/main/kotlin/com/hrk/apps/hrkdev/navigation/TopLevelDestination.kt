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

import androidx.compose.ui.graphics.vector.ImageVector
import com.hrk.apps.hrkdev.core.designsystem.icon.HRKIcons
import com.hrk.base.home.navigation.HomeRoute
import com.hrk.base.other.navigation.OtherRoute
import com.hrk.base.setting.navigation.SettingRoute
import kotlin.reflect.KClass

/**
 * Type for the top level destinations in the application. Each of these destinations
 * can contain one or more screens (based on the window size). Navigation from one screen to the
 * next within a single destination will be handled directly in composables.
 */
enum class TopLevelDestination(
    val selectedIcon: ImageVector,
    val unselectedIcon: ImageVector,
    val route: KClass<*>,
) {
    HOME(
        selectedIcon = HRKIcons.Upcoming,
        unselectedIcon = HRKIcons.UpcomingBorder,
        route = HomeRoute::class,
    ),
    SETTING(
        selectedIcon = HRKIcons.Bookmarks,
        unselectedIcon = HRKIcons.BookmarksBorder,
        route = SettingRoute::class,
    ),
    OTHER(
        selectedIcon = HRKIcons.Grid3x3,
        unselectedIcon = HRKIcons.Grid3x3,
        route = OtherRoute::class,
    ),
}
