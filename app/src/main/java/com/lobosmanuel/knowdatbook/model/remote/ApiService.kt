package com.lobosmanuel.knowdatbook.model.remote

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

//acá están los endpoints de búsqueda para que retrofic los construya

interface ApiService {
    @GET("search.json")
    suspend fun searchBooks(
        @Query("q") query: String,
        @Query("limit") limit: Int = 100 // Traemos pocos para que sea rápido
    ): Response<OpenLibraryResponse>
}