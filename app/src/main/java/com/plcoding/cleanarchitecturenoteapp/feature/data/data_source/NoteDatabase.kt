package com.plcoding.cleanarchitecturenoteapp.feature.data.data_source

import androidx.room.Database
import androidx.room.RoomDatabase
import com.plcoding.cleanarchitecturenoteapp.feature.domain.model.Note


@Database(
    entities = [Note::class],
    version = 1
)
abstract class NoteDatabase: RoomDatabase() {
    abstract val noteDao: NoteDAO

    companion object{
        const val DATABASE_NAME = "notes_db"
    }
}

