package com.plcoding.cleanarchitecturenoteapp.feature.domain.use_case


import com.plcoding.cleanarchitecturenoteapp.feature.domain.model.Note
import com.plcoding.cleanarchitecturenoteapp.feature.domain.repository.NoteRepository
import com.plcoding.cleanarchitecturenoteapp.feature.domain.util.NoteOrder
import com.plcoding.cleanarchitecturenoteapp.feature.domain.util.OrderType
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class GetNotesUseCase(private val repository: NoteRepository) {

    operator fun invoke(
        noteOrder: NoteOrder = NoteOrder.Date(OrderType.Descending)): Flow<List<Note>>{

        //map the repository to a new list
        return repository.getNotes().map { notes ->
            //Ascending order
            when(noteOrder.orderType){
                is OrderType.Ascending -> {
                    when(noteOrder){
                        is NoteOrder.Title -> notes.sortedBy { it.title.lowercase() }
                        is NoteOrder.Date -> notes.sortedBy { it.timestamp }
                        is NoteOrder.Colour -> notes.sortedBy { it.colour }
                    }
                }
                //Descending order
                is OrderType.Descending -> {
                        when(noteOrder){
                            is NoteOrder.Title -> notes.sortedByDescending { it.title.lowercase() }
                            is NoteOrder.Date -> notes.sortedByDescending { it.timestamp }
                            is NoteOrder.Colour -> notes.sortedByDescending { it.colour }
                        }
                    }
                }
            }

        }
    }

