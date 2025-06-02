package com.example.android.wearable.composeforwearos.network


import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitClient {
    private const val BASE_URL_LOCAL = "http://localhost:8000/api/blog" // para emulador
    //private const val BASE_URL_ONLINE = "https://tuservidor/api/" // reemplaza con tu URL pública

    val apiService: BlogApiService by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL_LOCAL) // o BASE_URL_ONLINE
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(BlogApiService::class.java)
    }
}