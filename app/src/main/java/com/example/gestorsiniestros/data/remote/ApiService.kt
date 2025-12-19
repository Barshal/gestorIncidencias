package com.example.gestorsiniestros.data.remote

import OrdenesEstadoRequest
import com.example.gestorsiniestros.data.model.OrdenEstado
import com.example.gestorsiniestros.data.model.OrdenResumen
import com.example.gestorsiniestros.data.remote.dto.OrdenesResumenRequest
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.Headers
import retrofit2.http.POST

interface ApiService {
    //Esta funcion retorna un count de las ordenes de trabajo por estado

    @Headers(
        "Content-Type: application/json",
        "Accept: application/json"
    )
    @POST("get-cuadro-general")
    suspend fun getOrdenesEstado(
        @Body filtro: OrdenesEstadoRequest
    ): Response<List<OrdenEstado>>

    //Esta funcion retorna una colección de ordenes de trabajo
    @Headers(
        "Content-Type: application/json",
        "Accept: application/json"
    )
    @POST("get-cuadro-estado")
    suspend fun getOrdenesTrabajo(
        @Body filtro: OrdenesResumenRequest
    ): Response<List<OrdenResumen>>


}
