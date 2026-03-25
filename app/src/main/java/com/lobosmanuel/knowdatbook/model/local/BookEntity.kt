package com.lobosmanuel.knowdatbook.model.local

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

// En BookRemote, usaste key como tipo String. Esto es perfecto para OpenLibrary
// (envían algo como /works/OL12345W). Cuando pases esto a tu BookEntity local
// más adelante, recuerda que la PrimaryKey de Room también deberá ser String.


@Entity(tableName = "fav_books_table")
data class BookEntity(
    @PrimaryKey
    val id: String,
    val title: String,
    val authorName: String?,
    val coverId: Int?,
    // Campos nuevos para que el ciclo funcione:
    val rating: Float = 0f,
    val isRead: Boolean = false
)
