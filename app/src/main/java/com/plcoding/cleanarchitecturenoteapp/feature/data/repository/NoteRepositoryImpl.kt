package com.plcoding.cleanarchitecturenoteapp.feature.data.repository

import com.plcoding.cleanarchitecturenoteapp.feature.data.data_source.NoteDAO
import com.plcoding.cleanarchitecturenoteapp.feature.domain.model.Note
import com.plcoding.cleanarchitecturenoteapp.feature.domain.repository.NoteRepository
import kotlinx.coroutines.flow.Flow

//Implementation of repository
class NoteRepositoryImpl(private val dao: NoteDAO): NoteRepository {

    override fun getNotes(): Flow<List<Note>> {
       return dao.getNotes()
    }

    override suspend fun getNoteById(id: Int): Note? {
        return dao.getNoteById(id)
    }

    override suspend fun insertNote(note: Note) {
        return dao.insertNote(note)
    }

    override suspend fun deleteNote(note: Note) {
        return dao.deleteNote(note)
    }
}