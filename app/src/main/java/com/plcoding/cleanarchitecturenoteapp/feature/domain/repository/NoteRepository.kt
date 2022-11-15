package com.plcoding.cleanarchitecturenoteapp.feature.domain.repository


import com.plcoding.cleanarchitecturenoteapp.feature.domain.model.Note
import kotlinx.coroutines.flow.Flow


//interface created to be able to use for test cases
interface NoteRepository {

    fun getNotes(): Flow<List<Note>>

    suspend fun getNoteById(id: Int): Note?

    suspend fun insertNote(note: Note)

    suspend fun deleteNote(note: Note)
}