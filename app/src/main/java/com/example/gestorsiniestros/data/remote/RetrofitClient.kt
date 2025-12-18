package com.example.gestorsiniestros.data.remote

// 1. CORRECCIÓN: La importación de ApiService debe ser completa.
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitClient {
    private const val BASE_URL = "https://acceso.intranext.es/api/gestinsin/v1/"

    val instance: ApiService by lazy {
        // 3. MEJORA: Añadido un interceptor de logging para depurar las llamadas a la API.
        //    Esto te permitirá ver en el Logcat qué envías y qué recibes.
        val logging = HttpLoggingInterceptor()
        logging.setLevel(HttpLoggingInterceptor.Level.BODY)

        val client = OkHttpClient.Builder()
            .addInterceptor(logging)
            .build()

        val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(client) // <-- Se añade el cliente con el interceptor
            .build()

        retrofit.create(ApiService::class.java)
    }
}
