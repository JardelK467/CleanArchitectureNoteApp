package com.plcoding.cleanarchitecturenoteapp.feature.domain.use_case

import com.plcoding.cleanarchitecturenoteapp.feature.domain.model.Note
import com.plcoding.cleanarchitecturenoteapp.feature.domain.repository.NoteRepository

class DeleteNoteUseCase(private val repository: NoteRepository) {

    suspend operator fun invoke(note: Note){
        return repository.deleteNote(note)
    }

}