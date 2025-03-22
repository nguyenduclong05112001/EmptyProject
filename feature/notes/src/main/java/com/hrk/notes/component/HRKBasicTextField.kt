package com.hrk.notes.component

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberUpdatedState
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.font.FontWeight.Companion.W400
import androidx.compose.ui.unit.dp
import com.hrk.apps.hrkdev.core.designsystem.utils.ComposeUtils.clickableSingle

@Composable
fun HRKBasicTextField(
    modifier: Modifier = Modifier,
    placeholder: String,
    textValues: String,
    minLines: Int = 1,
    maxLines: Int = Int.MAX_VALUE,
    keyboardOptions: KeyboardOptions,
    textStyle: TextStyle,
    onTextChanged: (String) -> Unit,
) {
    val focusRequester = remember { FocusRequester() }
    var isFocusedState by remember { mutableStateOf(false) }
    val updatedOnTextChanged by rememberUpdatedState(onTextChanged)

    Box(
        modifier = modifier
            .fillMaxWidth()
            .clickableSingle { focusRequester.requestFocus() }
            .padding(12.dp)
    ) {
        BasicTextField(
            value = textValues,
            onValueChange = updatedOnTextChanged,
            modifier = Modifier
                .focusRequester(focusRequester)
                .onFocusChanged { isFocusedState = it.isFocused }
                .fillMaxWidth(),
            singleLine = false,
            minLines = minLines,
            maxLines = maxLines,
            keyboardOptions = keyboardOptions,
            textStyle = textStyle,
            cursorBrush = SolidColor(Color.White),
            decorationBox = { innerTextField ->
                Box {
                    if (textValues.isEmpty()) {
                        Text(
                            text = placeholder,
                            style = textStyle.copy(
                                color = textStyle.color.copy(alpha = 0.6f),
                                fontWeight = W400
                            ),
                        )
                    }
                    innerTextField()
                }
            }
        )
    }
}