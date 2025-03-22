package com.hrk.notes.create_note

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.ime
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight.Companion.W500
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.hrk.apps.hrkdev.core.designsystem.utils.ComposeUtils.backgroundApp
import com.hrk.notes.component.HRKBasicTextField
import com.hrk.notes.create_note.component.CreateNoteTopBarComponent

@Composable
fun CreateNoteScreen(
    onBack: () -> Unit,
    onPreviewNote: () -> Unit,
    viewModel: CreateNoteViewModel = hiltViewModel()
) {
    val imeInsets = WindowInsets.ime
    val imeHeight = imeInsets.getBottom(LocalDensity.current) // Lấy chiều cao bàn phím
    val uiState by viewModel.uiState.collectAsState()

    var title by remember { mutableStateOf("") }
    var description by remember { mutableStateOf("") }

    Scaffold(
        modifier = Modifier.fillMaxSize(),
        topBar = {
            CreateNoteTopBarComponent(
                modifier = Modifier
                    .fillMaxWidth()
                    .backgroundApp()
                    .statusBarsPadding()
                    .padding(horizontal = 16.dp, vertical = 8.dp)
                    .padding(bottom = 12.dp),
                onSaveNote = {},
                onBack = onBack
            )
        },
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .padding(paddingValues)
                .fillMaxSize()
                .backgroundApp()
                .padding(horizontal = 16.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            HRKBasicTextField(
                modifier = Modifier.fillMaxWidth(),
                placeholder = "Title",
                textValues = title,
                maxLines = 5,
                keyboardOptions = KeyboardOptions(imeAction = ImeAction.Next),
                textStyle = TextStyle(
                    color = Color.White,
                    fontSize = 24.sp,
                    lineHeight = 32.sp,
                    fontWeight = W500,
                ),
                onTextChanged = { title = it }
            )

            HRKBasicTextField(
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1f),
                placeholder = "Type something...",
                textValues = description,
                keyboardOptions = KeyboardOptions(imeAction = ImeAction.Unspecified),
                textStyle = TextStyle(
                    color = Color.White,
                    fontSize = 12.sp,
                    lineHeight = 16.sp,
                    fontWeight = W500,
                ),
                onTextChanged = { description = it }
            )

            Spacer(modifier = Modifier.height(imeHeight.dp)) // 🔥 Đẩy Row lên trên bàn phím đúng khoảng cách

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Color.White.copy(0.3f))
                    .padding(vertical = 12.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                Text("Bottom Toolbar", color = Color.White)
            }
        }
    }
}


