package com.example.gestorsiniestros.data.remote

import OrdenesGeneralRequest
import com.example.gestorsiniestros.data.model.OrdenEstado
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.Headers
import retrofit2.http.POST

interface ApiService {
    @Headers(
        "Content-Type: application/json",
        "Accept: application/json"
    )
    @POST("get-cuadro-general")
    suspend fun getOrdenesEstado(
        @Body filtro: OrdenesGeneralRequest
    ): Response<List<OrdenEstado>>
}
