package com.hrk.apps.hrkdev.core.data.repository

import com.hrk.apps.hrkdev.core.model.note.NoteUI
import kotlinx.coroutines.flow.Flow

interface NoteRepository {
    fun getNotes(): Flow<List<NoteUI>>

    fun insertNote(
        noteUI: NoteUI
    ): Flow<Long>

    fun updateNote(
        noteUI: NoteUI
    ): Flow<Int>

    fun deleteNote(
        noteUI: NoteUI
    ): Flow<Int>
}