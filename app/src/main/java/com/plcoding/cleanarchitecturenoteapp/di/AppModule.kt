package com.plcoding.cleanarchitecturenoteapp.di

import android.app.Application
import androidx.room.Room
import com.plcoding.cleanarchitecturenoteapp.feature.data.data_source.NoteDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import javax.inject.Singleton

@Module
@InstallIn
object AppModule {

    @Provides
    @Singleton
    fun provideNoteDatabase(app: Application): NoteDatabase {
        return Room.databaseBuilder(
            app,
            NoteDatabase::class.java,
            NoteDatabase.DATABASE_NAME).build()
    }
}