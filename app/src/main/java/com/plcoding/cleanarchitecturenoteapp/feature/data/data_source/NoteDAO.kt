package com.plcoding.cleanarchitecturenoteapp.feature.data.data_source

import androidx.room.*
import com.plcoding.cleanarchitecturenoteapp.feature.domain.model.Note
import kotlinx.coroutines.flow.Flow

//Querying database
@Dao
interface NoteDAO {
    //outputs all notes in the database
    @Query("SELECT * FROM note")
    fun getNotes(): Flow<List<Note>>
    //outputs the note by id
    @Query("SELECT * FROM note WHERE id = :id")
    suspend fun getNoteById(id: Int): Note?

    //adds a note to the database
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertNote(note: Note)
    //deletes note from database
    @Delete
    suspend fun deleteNote(note: Note)
}