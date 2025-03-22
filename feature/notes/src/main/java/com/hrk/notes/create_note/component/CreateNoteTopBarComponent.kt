package com.hrk.notes.create_note.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.hrk.apps.hrkdev.core.designsystem.icon.HRKIcons
import com.hrk.apps.hrkdev.core.designsystem.utils.ComposeUtils.clickableSingle

@Composable
fun CreateNoteTopBarComponent(
    modifier: Modifier,
    onBack: () -> Unit,
    onSaveNote: () -> Unit,
) {
    Box(
        modifier = modifier
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Box(
                modifier = Modifier
                    .clip(RoundedCornerShape(8.dp))
                    .size(48.dp)
                    .background(Color.White.copy(0.2f))
                    .clickableSingle {
                        onBack.invoke()
                    }
            ) {
                Icon(
                    modifier = Modifier
                        .align(Alignment.Center)
                        .size(24.dp),
                    painter = painterResource(HRKIcons.ArrowLeftIcon.resourceId),
                    contentDescription = null,
                    tint = Color.White
                )
            }

            Box(
                modifier = Modifier
                    .clip(RoundedCornerShape(8.dp))
                    .size(48.dp)
                    .background(Color.White.copy(0.2f))
                    .clickableSingle {
                        onSaveNote.invoke()
                    }
            ) {
                Icon(
                    modifier = Modifier
                        .align(Alignment.Center)
                        .size(24.dp),
                    painter = painterResource(HRKIcons.SaveIcon.resourceId),
                    contentDescription = null,
                    tint = Color.White
                )
            }

        }
    }
}