package com.hrk.apps.hrkdev.core.data.di

import com.hrk.apps.hrkdev.core.data.repository.NoteRepository
import com.hrk.apps.hrkdev.core.data.repository.NoteRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
interface RepositoryModule {
    @Singleton
    @Binds
    fun bindNoteRepository(noteRepository: NoteRepositoryImpl): NoteRepository
}