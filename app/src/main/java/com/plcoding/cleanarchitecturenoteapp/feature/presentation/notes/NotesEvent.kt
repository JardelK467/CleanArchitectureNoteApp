package com.plcoding.cleanarchitecturenoteapp.feature.presentation.notes


import com.plcoding.cleanarchitecturenoteapp.feature.domain.util.NoteOrder
import com.plcoding.cleanarchitecturenoteapp.feature.domain.model.Note

sealed class NotesEvent{
    data class Order(val noteOrder: NoteOrder): NotesEvent()
    data class DeleteNote(val note: Note): NotesEvent()
    object RestoreNote: NotesEvent()
    object ToggleOrderSelection: NotesEvent()
}
