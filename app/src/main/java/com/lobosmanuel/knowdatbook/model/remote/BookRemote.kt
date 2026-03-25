package com.lobosmanuel.knowdatbook.model.remote

import com.google.gson.annotations.SerializedName

//NOTA IMPORTANTE: el autor viene como lista no como String

data class BookRemote(
    @SerializedName("key") val key: String, // La "PK" de la API
    @SerializedName("title") val title: String,
    @SerializedName("author_name") val authorNames: List<String>?, // Es una lista
    @SerializedName("cover_i") val coverId: Int?, // ID para la imagen
    @SerializedName("first_publish_year") val year: Int?
)