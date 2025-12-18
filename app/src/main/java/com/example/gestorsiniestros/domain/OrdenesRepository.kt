package com.example.gestorsiniestros.domain

import OrdenesGeneralRequest
import android.util.Log
import com.example.gestorsiniestros.data.model.OrdenEstado
import com.example.gestorsiniestros.data.remote.RetrofitClient

class OrdenesRepository {

    // 1. Definimos las URLs Base
    private val baseUrlPrincipal = "https://acceso.intranext.es/api/gestinsin/v1/"
    private val baseUrlRespaldo = "https://acceso2.intranext.es/api/gestinsin/v1/"

    // 2. Creamos los dos servicios de API, uno para cada URL
    private val apiServicePrincipal = RetrofitClient.createService(baseUrlPrincipal)
    private val apiServiceRespaldo = RetrofitClient.createService(baseUrlRespaldo)

    suspend fun getOrdenesEstado(filtro: OrdenesGeneralRequest): List<OrdenEstado> {
        try {
            // --- INTENTO 1: LLAMAR AL SERVICIO PRINCIPAL ---
            Log.d("OrdenesRepository", "Intentando llamar al endpoint principal...")
            val response = apiServicePrincipal.getOrdenesEstado(filtro) // Usamos el servicio principal

            if (response.isSuccessful) {
                Log.d("OrdenesRepository", "Éxito en el endpoint principal.")
                return response.body() ?: emptyList()
            } else {
                throw Exception("Error del servidor en endpoint principal: ${response.code()}")
            }

        } catch (e: Exception) {
            // --- FALLBACK: SI EL INTENTO 1 FALLA ---
            Log.w("OrdenesRepository", "El endpoint principal falló: ${e.message}. Intentando con el de respaldo.")

            try {
                // --- INTENTO 2: LLAMAR AL SERVICIO DE RESPALDO ---
                Log.d("OrdenesRepository", "Intentando llamar al endpoint de respaldo...")
                val responseRespaldo = apiServiceRespaldo.getOrdenesEstado(filtro) // Usamos el servicio de respaldo

                if (responseRespaldo.isSuccessful) {
                    Log.d("OrdenesRepository", "Éxito en el endpoint de respaldo.")
                    return responseRespaldo.body() ?: emptyList()
                } else {
                    throw Exception("Error del servidor en endpoint de respaldo: ${responseRespaldo.code()}")
                }
            } catch (e2: Exception) {
                Log.e("OrdenesRepository", "El endpoint de respaldo también falló: ${e2.message}")
                throw e2 // Si ambos fallan, relanzamos la excepción
            }
        }
    }
}
