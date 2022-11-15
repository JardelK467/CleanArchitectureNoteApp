package com.plcoding.cleanarchitecturenoteapp.feature.domain.util

sealed class NoteOrder(val orderType: OrderType){
    class Title(orderType: OrderType): NoteOrder(orderType)
    class Date(orderType: OrderType): NoteOrder(orderType)
    class Colour(orderType: OrderType): NoteOrder(orderType)
}

