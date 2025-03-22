package com.hrk.notes.create_note

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight.Companion.W500
import androidx.compose.ui.unit.sp
import com.hrk.apps.hrkdev.core.viewmodel.BaseViewModel
import com.hrk.notes.model.NoteUI
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject


@HiltViewModel
class CreateNoteViewModel @Inject constructor() :
    BaseViewModel<CreateNoteUiState, CreateNoteEvent>(CreateNoteUiState()) {
    override fun handleEvent(event: CreateNoteEvent) {
        when (event) {
            is CreateNoteEvent.SaveNote -> saveNote(event)
        }
    }

    private fun saveNote(event: CreateNoteEvent.SaveNote) {

    }
}

sealed class CreateNoteEvent {
    data class SaveNote(val noteUI: NoteUI) : CreateNoteEvent()
}

data class CreateNoteUiState(
    val currentNoteUI: NoteUI? = null,

    val currentStyle: TextStyle = TextStyle(
        color = Color.White,
        fontSize = 12.sp,
        lineHeight = 16.sp,
        fontWeight = W500,
    )
)
