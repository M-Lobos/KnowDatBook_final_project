package com.lobosmanuel.knowdatbook.model.remote

import com.google.gson.annotations.SerializedName

//OL devuelve objetos gigantes, pero solo interesa ahora, docs (creo)

data class OpenLibraryResponse(
    @SerializedName("numFound") val total: Int,
    @SerializedName("docs") val books: List<BookRemote> //
)