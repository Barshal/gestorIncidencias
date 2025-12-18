package com.example.gestorsiniestros.domain

// 1. Importa el modelo de datos para el cuerpo de la petición.
//    Asegúrate de que la ruta de importación sea la correcta.
import OrdenesGeneralRequest
import com.example.gestorsiniestros.data.model.OrdenEstado
import com.example.gestorsiniestros.data.remote.RetrofitClient

class OrdenesRepository {
    private val apiService = RetrofitClient.instance
    suspend fun getOrdenesEstado(filtro: OrdenesGeneralRequest): List<OrdenEstado> {

        val response = apiService.getOrdenesEstado(filtro)

        if (response.isSuccessful) {
            return response.body() ?: emptyList()
        }
        return emptyList()
    }
}
