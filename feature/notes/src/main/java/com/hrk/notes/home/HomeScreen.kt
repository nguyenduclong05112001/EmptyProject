package com.hrk.notes.home

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.lazy.staggeredgrid.LazyVerticalStaggeredGrid
import androidx.compose.foundation.lazy.staggeredgrid.StaggeredGridCells
import androidx.compose.foundation.lazy.staggeredgrid.rememberLazyStaggeredGridState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight.Companion.W400
import androidx.compose.ui.text.font.FontWeight.Companion.W600
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.hrk.apps.hrkdev.core.designsystem.icon.HRKIcons
import com.hrk.apps.hrkdev.core.designsystem.utils.ComposeUtils.backgroundApp
import com.hrk.apps.hrkdev.core.designsystem.utils.ComposeUtils.clickableSingle
import com.hrk.notes.home.cpmponent.HomeTopBarComponent
import kotlin.random.Random

@Composable
fun HomeScreen(
    onCreateNewNote: () -> Unit
) {
    val state = rememberLazyStaggeredGridState()

    Scaffold(
        modifier = Modifier.fillMaxSize(),
        floatingActionButton = {
            Box(
                modifier = Modifier
                    .padding(end = 12.dp)
                    .navigationBarsPadding()
                    .clip(CircleShape)
                    .border(
                        width = 1.dp,
                        color = Color.Black,
                        shape = CircleShape
                    )
                    .backgroundApp()
                    .clickableSingle {
                        onCreateNewNote.invoke()
                    }
            ) {
                Icon(
                    modifier = Modifier
                        .padding(12.dp)
                        .align(Alignment.Center)
                        .size(48.dp),
                    painter = painterResource(HRKIcons.AddIcon.resourceId),
                    tint = Color.White,
                    contentDescription = null
                )
            }
        },
        topBar = {
            HomeTopBarComponent(
                modifier = Modifier
                    .fillMaxWidth()
                    .backgroundApp()
                    .statusBarsPadding()
                    .padding(horizontal = 16.dp, vertical = 8.dp)
                    .padding(bottom = 12.dp)
            )
        },
    ) { paddingValues ->
        LazyVerticalStaggeredGrid(
            modifier = Modifier
                .padding(paddingValues)
                .fillMaxSize()
                .backgroundApp()
                .padding(horizontal = 16.dp),
            columns = StaggeredGridCells.Fixed(2),
            verticalItemSpacing = 16.dp,
            horizontalArrangement = Arrangement.spacedBy(16.dp),
            state = state,
        ) {
            items(10) {
                Column(
                    modifier = Modifier
                        .shadow(
                            elevation = 8.dp,
                            shape = RoundedCornerShape(12.dp)
                        )
                        .clip(RoundedCornerShape(12.dp))
                        .fillMaxWidth()
                        .background(Color(0xFFF5F3E8))
                        .padding(12.dp),
                    verticalArrangement = Arrangement.spacedBy(12.dp)
                ) {
                    Text(
                        modifier = Modifier.fillMaxWidth(),
                        text = "Book Review : The Design of Everyday Things by Don Norman",
                        maxLines = 2,
                        overflow = TextOverflow.Ellipsis,
                        style = TextStyle(
                            fontWeight = W600,
                            color = Color.Black,
                            fontSize = 16.sp,
                            lineHeight = 20.sp
                        )
                    )

                    HorizontalDivider(
                        modifier = Modifier.fillMaxWidth(),
                        color = Color.Black.copy(alpha = 03f),
                    )

                    Text(
                        modifier = Modifier.fillMaxWidth(),
                        text = "It is a long established fact that a reader will be distracted by the readable content of a page when looking at its layout. The point of using Lorem Ipsum is that it has a more-or-less normal distribution of letters, as opposed to using 'Content here, content here', making it look like readable English. Many desktop publishing packages and web page editors now use Lorem Ipsum as their default model text, and a search for 'lorem ipsum' will uncover many web sites still in their infancy. Various versions have evolved over the years, sometimes by accident, sometimes on purpose (injected humour and the like)",
                        maxLines = maxLine(),
                        overflow = TextOverflow.Ellipsis,
                        style = TextStyle(
                            fontWeight = W400,
                            color = Color.Black,
                            fontSize = 12.sp,
                            lineHeight = 16.sp
                        )
                    )
                }
            }
        }
    }
}

fun maxLine(): Int {
    return Random.nextInt(4, 8)
}

@Preview(showBackground = true)
@Composable
private fun PreviewUi() {
    HomeScreen({})
}