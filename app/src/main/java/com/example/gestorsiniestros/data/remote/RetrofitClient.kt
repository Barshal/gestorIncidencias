package com.example.gestorsiniestros.data.remote

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitClient {

    // 1. Mantenemos el cliente OkHttpClient centralizado.
    //    El interceptor de logs se aplicará a AMBAS llamadas.
    private val okHttpClient: OkHttpClient by lazy {
        val logging = HttpLoggingInterceptor()
        logging.setLevel(HttpLoggingInterceptor.Level.BODY)
        OkHttpClient.Builder()
            .addInterceptor(logging)
            .build()
    }

    // 2. Creamos una FUNCIÓN que genera un servicio de Retrofit para una URL base específica.
    fun createService(baseUrl: String): ApiService {
        val retrofit = Retrofit.Builder()
            .baseUrl(baseUrl) // <-- Usará la URL que le pasemos
            .addConverterFactory(GsonConverterFactory.create())
            .client(okHttpClient) // Reutilizamos el mismo cliente
            .build()

        return retrofit.create(ApiService::class.java)
    }
}
