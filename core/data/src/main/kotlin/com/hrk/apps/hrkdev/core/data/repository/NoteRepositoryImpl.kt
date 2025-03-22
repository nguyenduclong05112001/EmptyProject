package com.hrk.apps.hrkdev.core.data.repository

import com.hrk.apps.hrkdev.core.model.note.NoteUI
import com.hrk.database.room.dao.NotesDAO
import com.hrk.database.room.model.NoteEntity
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject
import javax.inject.Named

class NoteRepositoryImpl @Inject constructor(
    @Named("io") private val ioDispatcher: CoroutineDispatcher,
    private val notesDAO: NotesDAO,
) : NoteRepository {
    override fun getNotes(): Flow<List<NoteUI>> {
        return flow {
            val response = notesDAO.getNoteEntities().map {
                NoteUI(
                    noteId = it.noteId,
                    title = it.title,
                    description = it.description
                )
            }
            emit(response)
        }.flowOn(ioDispatcher)
    }

    override fun insertNote(noteUI: NoteUI): Flow<Long> {
        return flow {
            val response = notesDAO.insertNote(
                NoteEntity(
                    noteId = noteUI.noteId.orEmpty(),
                    title = noteUI.title.orEmpty(),
                    description = noteUI.description.orEmpty(),
                    createdAt = System.currentTimeMillis()
                )
            )
            emit(response)
        }.flowOn(ioDispatcher)
    }

    override fun updateNote(noteUI: NoteUI): Flow<Int> {
        return flow {
            val response = notesDAO.updateNote(
                NoteEntity(
                    noteId = noteUI.noteId.orEmpty(),
                    title = noteUI.title.orEmpty(),
                    description = noteUI.description.orEmpty(),
                    createdAt = System.currentTimeMillis()
                )
            )
            emit(response)
        }.flowOn(ioDispatcher)
    }

    override fun deleteNote(noteUI: NoteUI): Flow<Int> {
        return flow {
            val response = notesDAO.deleteNote(
                NoteEntity(
                    noteId = noteUI.noteId.orEmpty(),
                    title = noteUI.title.orEmpty(),
                    description = noteUI.description.orEmpty(),
                    createdAt = System.currentTimeMillis()
                )
            )
            emit(response)
        }.flowOn(ioDispatcher)
    }

}