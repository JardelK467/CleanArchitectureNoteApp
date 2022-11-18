package com.plcoding.cleanarchitecturenoteapp.feature.domain.use_case

import com.plcoding.cleanarchitecturenoteapp.feature.domain.model.InvalidNoteException
import com.plcoding.cleanarchitecturenoteapp.feature.domain.model.Note
import com.plcoding.cleanarchitecturenoteapp.feature.domain.repository.NoteRepository

class InsertNoteUseCase(private val repository: NoteRepository) {

    suspend operator fun invoke(note: Note) {

        @Throws(InvalidNoteException::class)
        if(note.title.isBlank()){
            throw InvalidNoteException("The title of the note can't be empty")
        }
        if(note.content.isBlank()){
            throw InvalidNoteException("The content of the note can't be empty")
        }
        repository.insertNote(note)
    }

}