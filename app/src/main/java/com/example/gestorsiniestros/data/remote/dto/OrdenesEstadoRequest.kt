package com.example.gestorsiniestros.data.remote.dto

data class OrdenesEstadoRequest(
    val usuarioId: String,
    val empresaId: String,
    val estado: String
)