/*
 * Copyright 2023 The Android Open Source Project
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

package com.hrk.apps.hrkdev.core.designsystem

import androidx.activity.ComponentActivity
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.platform.LocalInspectionMode
import androidx.compose.ui.test.DeviceConfigurationOverride
import androidx.compose.ui.test.FontScale
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.compose.ui.test.onRoot
import com.github.takahirom.roborazzi.captureRoboImage
import com.hrk.apps.hrkdev.core.designsystem.component.HRKTab
import com.hrk.apps.hrkdev.core.designsystem.component.HRKTabRow
import com.hrk.apps.hrkdev.core.designsystem.theme.HRKTheme
import com.hrk.apps.hrkdev.core.testing.util.DefaultRoborazziOptions
import com.hrk.apps.hrkdev.core.testing.util.captureMultiTheme
import dagger.hilt.android.testing.HiltTestApplication
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner
import org.robolectric.annotation.Config
import org.robolectric.annotation.GraphicsMode
import org.robolectric.annotation.LooperMode

@RunWith(RobolectricTestRunner::class)
@GraphicsMode(GraphicsMode.Mode.NATIVE)
@Config(application = HiltTestApplication::class, qualifiers = "480dpi")
@LooperMode(LooperMode.Mode.PAUSED)
class TabsScreenshotTests {

    @get:Rule
    val composeTestRule = createAndroidComposeRule<ComponentActivity>()

    @Test
    fun tabs_multipleThemes() {
        composeTestRule.captureMultiTheme("Tabs") {
            HRKTabsExample()
        }
    }

    @Test
    fun tabs_hugeFont() {
        composeTestRule.setContent {
            CompositionLocalProvider(
                LocalInspectionMode provides true,
            ) {
                DeviceConfigurationOverride(
                    DeviceConfigurationOverride.FontScale(2f),
                ) {
                    HRKTheme {
                        HRKTabsExample("Looooong item")
                    }
                }
            }
        }
        composeTestRule.onRoot()
            .captureRoboImage(
                "src/test/screenshots/Tabs/Tabs_fontScale2.png",
                roborazziOptions = DefaultRoborazziOptions,
            )
    }

    @Composable
    private fun HRKTabsExample(label: String = "Topics") {
        Surface {
            val titles = listOf(label, "People")
            HRKTabRow(selectedTabIndex = 0) {
                titles.forEachIndexed { index, title ->
                    HRKTab(
                        selected = index == 0,
                        onClick = { },
                        text = { Text(text = title) },
                    )
                }
            }
        }
    }
}
