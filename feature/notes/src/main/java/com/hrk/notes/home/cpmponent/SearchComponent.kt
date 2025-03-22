package com.hrk.notes.home.cpmponent

import androidx.annotation.DrawableRes
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight.Companion.W500
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.hrk.apps.hrkdev.core.designsystem.icon.HRKIcons
import com.hrk.apps.hrkdev.core.designsystem.utils.ComposeUtils.clickableSingle

@Composable
fun SearchComponent(
    modifier: Modifier = Modifier,
    placeholder: String,
    searchText: String,
    @DrawableRes leadingIcon: Int = HRKIcons.SearchIcon.resourceId,
    leadingIconTint: Color = Color.White,
    @DrawableRes trailingIcon: Int = HRKIcons.CloseIcon.resourceId,
    trailingIconIconTint: Color = Color.White,
    onTrailingIconClick: () -> Unit = {},
    onTextChanged: (String) -> Unit,
    onSearchClick: () -> Unit = {},
) {
    var isFocusedState by remember {
        mutableStateOf(false)
    }

    val focusManager = LocalFocusManager.current

    BasicTextField(
        value = searchText,
        onValueChange = onTextChanged,
        modifier = modifier
            .onFocusChanged {
                isFocusedState = it.isFocused
            },
        singleLine = true,
        keyboardOptions = KeyboardOptions(
            imeAction = ImeAction.Search
        ),
        keyboardActions = KeyboardActions(onSearch = {
            focusManager.clearFocus()
            onSearchClick.invoke()
        }),
        textStyle = TextStyle(
            color = leadingIconTint,
            fontSize = 12.sp,
            lineHeight = 16.sp,
            fontWeight = W500,
        ),
        decorationBox = { innerTextField ->
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .border(
                        width = if (isFocusedState) 2.dp else 1.dp,
                        color = leadingIconTint,
                        shape = RoundedCornerShape(size = 8.dp)
                    )
                    .padding(12.dp)
            ) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Icon(
                        painter = painterResource(id = leadingIcon),
                        contentDescription = null,
                        modifier = Modifier.size(16.dp),
                        tint = leadingIconTint
                    )
                    Spacer(modifier = Modifier.width(8.dp))
                    Box(modifier = Modifier.weight(1f)) {
                        if (searchText.isEmpty()) {
                            Text(
                                text = placeholder,
                                style = TextStyle(
                                    color = leadingIconTint.copy(0.6f),
                                    fontSize = 12.sp,
                                    lineHeight = 16.sp,
                                    fontWeight = W500,
                                ),
                                maxLines = 1,
                                overflow = TextOverflow.Ellipsis
                            )
                        }
                        innerTextField()
                    }

                    Spacer(modifier = Modifier.width(8.dp))
                    Icon(
                        painter = painterResource(id = trailingIcon),
                        contentDescription = null,
                        modifier = Modifier
                            .size(16.dp)
                            .clickableSingle {
                                onTrailingIconClick()
                            },
                        tint = trailingIconIconTint
                    )
                }
            }
        }
    )
}