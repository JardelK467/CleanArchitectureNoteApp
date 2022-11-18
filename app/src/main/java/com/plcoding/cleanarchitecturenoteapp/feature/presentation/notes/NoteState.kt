package com.plcoding.cleanarchitecturenoteapp.feature.presentation.notes

import com.plcoding.cleanarchitecturenoteapp.feature.domain.model.Note
import com.plcoding.cleanarchitecturenoteapp.feature.domain.util.NoteOrder
import com.plcoding.cleanarchitecturenoteapp.feature.domain.util.OrderType

//Actions
data class NoteState(
    val notes: List<Note> = emptyList(),
    val noteOrder: NoteOrder = NoteOrder.Date(OrderType.Descending),
    val isOrderSectionVisible: Boolean = false
)
