package com.hrk.notes.home.cpmponent

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight.Companion.W700
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.hrk.apps.hrkdev.core.designsystem.icon.HRKIcons
import com.hrk.apps.hrkdev.core.designsystem.utils.ComposeUtils.clickableSingle

@Composable
 fun HomeTopBarComponent(
    modifier: Modifier,
) {
    val localDensity = LocalDensity.current
    var heightItem by remember {
        mutableStateOf(0.dp)
    }

    var isSearchState by remember {
        mutableStateOf(false)
    }
    Box(
        modifier = modifier
    ) {
        AnimatedVisibility(!isSearchState) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .onGloballyPositioned {
                        heightItem = with(localDensity) {
                            it.size.height.toDp()
                        }
                    },
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    text = "Notes",
                    style = TextStyle(
                        color = Color.White,
                        fontWeight = W700,
                        fontSize = 32.sp,
                        lineHeight = 48.sp
                    )
                )

                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(16.dp)
                ) {
                    Box(
                        modifier = Modifier
                            .clip(RoundedCornerShape(8.dp))
                            .size(48.dp)
                            .background(Color.White.copy(0.2f))
                            .clickableSingle {
                                isSearchState = true
                            }
                    ) {
                        Icon(
                            modifier = Modifier
                                .align(Alignment.Center)
                                .size(24.dp),
                            painter = painterResource(HRKIcons.SearchIcon.resourceId),
                            contentDescription = null,
                            tint = Color.White
                        )
                    }

                    Box(
                        modifier = Modifier
                            .clip(RoundedCornerShape(8.dp))
                            .size(48.dp)
                            .background(Color.White.copy(0.2f))
                    ) {
                        Icon(
                            modifier = Modifier
                                .align(Alignment.Center)
                                .size(24.dp),
                            painter = painterResource(HRKIcons.InfoIcon.resourceId),
                            contentDescription = null,
                            tint = Color.White
                        )
                    }
                }
            }
        }

        AnimatedVisibility(isSearchState) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(heightItem),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                Icon(
                    modifier = Modifier
                        .size(24.dp)
                        .clickableSingle {
                            isSearchState = false
                        },
                    painter = painterResource(HRKIcons.BlackIcon.resourceId),
                    contentDescription = null,
                    tint = Color.White
                )

                SearchComponent(
                    modifier = Modifier.weight(1f),
                    placeholder = "Search by the keyword...",
                    searchText = "",
                    onTextChanged = {}
                )
            }
        }
    }
}