package com.hrk.notes.model

import androidx.compose.ui.text.AnnotatedString

data class NoteUI(
    val noteId: String? = null,
    val title: AnnotatedString? = null,
    val description: AnnotatedString? = null,
)