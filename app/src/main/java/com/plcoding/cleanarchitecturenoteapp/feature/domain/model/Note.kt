package com.plcoding.cleanarchitecturenoteapp.feature.domain.model
import androidx.compose.ui.graphics.Color
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.plcoding.cleanarchitecturenoteapp.ui.theme.*

//Creating the fields for ROOM database
@Entity
data class Note(
    val title: String,
    val content: String,
    val timestamp: Long,
    val colour: Int,
    @PrimaryKey val id: Int? = null
){

    companion object{val noteColours = listOf(RedOrange, LightGreen, Violet, BabyBlue, RedPink) }
}

class InvalidNoteException(message: String): Exception(message)

