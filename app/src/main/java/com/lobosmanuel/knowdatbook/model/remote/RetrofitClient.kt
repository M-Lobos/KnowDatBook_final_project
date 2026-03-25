package com.lobosmanuel.knowdatbook.model.remote

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitClient {

    private val baseUrl = "https://openlibrary.org/"

    // Esta función devuelve la instancia del servicio ya configurada
    fun getApiService(): ApiService {
        return Retrofit.Builder()
            .baseUrl(baseUrl)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ApiService::class.java)
    }
}