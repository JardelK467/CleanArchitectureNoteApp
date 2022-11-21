package com.plcoding.cleanarchitecturenoteapp.feature.presentation.notes

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.compose.viewModel
import com.plcoding.cleanarchitecturenoteapp.feature.domain.model.Note
import com.plcoding.cleanarchitecturenoteapp.feature.domain.use_case.NoteUseCase
import com.plcoding.cleanarchitecturenoteapp.feature.domain.util.NoteOrder
import com.plcoding.cleanarchitecturenoteapp.feature.domain.util.OrderType
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class  NoteViewModel @Inject constructor(
    private val noteUseCase: NoteUseCase
): ViewModel(){

    private val _state = mutableStateOf(NoteState())
    private val state: State<NoteState> = _state

    private var recentlyDeletedNote: Note? = null
    private var getNotesJob: Job? = null //Helps to keep track

    init {
        //Initialises order
        getNotes(NoteOrder.Date(OrderType.Descending))
    }

    fun onEvent(event: NotesEvent){
        when(event){
            is NotesEvent.Order -> {
                if(state.value.noteOrder::class == event.noteOrder::class && state.value.noteOrder.orderType == event.noteOrder.orderType)
                    return

            }
            is NotesEvent.DeleteNote -> {
                viewModelScope.launch {
                    noteUseCase.deleteNoteUseCase(event.note)
                    recentlyDeletedNote = event.note
                }

            }
            is NotesEvent.RestoreNote -> {
                viewModelScope.launch {
                    noteUseCase.insertNoteUseCase(recentlyDeletedNote?: return@launch)
                    recentlyDeletedNote = null
                }

            }
            is NotesEvent.ToggleOrderSelection -> {
                _state.value = state.value.copy(
                    isOrderSectionVisible = !state.value.isOrderSectionVisible
                )

            }
        }


    }

    private fun getNotes(noteOrder: NoteOrder){

        getNotesJob?.cancel() //cancels flow
        getNotesJob = noteUseCase.getNotesUseCase(noteOrder)//creates new job

            .onEach { notes ->
                _state.value = state.value.copy(
                    notes = notes,
                    noteOrder = noteOrder
                )
            }
            .launchIn(viewModelScope)

    }


}

