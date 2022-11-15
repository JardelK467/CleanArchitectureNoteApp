package com.plcoding.cleanarchitecturenoteapp.feature.domain.util

sealed class OrderType{
    object Ascending: OrderType()
    object Descending: OrderType()
}
