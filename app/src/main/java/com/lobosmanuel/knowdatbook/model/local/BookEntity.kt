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
    @SerializedName("key") val id: String, // Usamos la 'key' de OpenLibrary como PK
    @SerializedName("title") val title: String,
    @SerializedName("author_name") val authorName: String?, // Guardamos el primer autor
    @SerializedName("cover_i") val coverId: Int?
)
