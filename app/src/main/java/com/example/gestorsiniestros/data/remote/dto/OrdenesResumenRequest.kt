package com.example.gestorsiniestros.data.remote.dto

import com.google.gson.annotations.SerializedName

data class OrdenesResumenRequest(
    @SerializedName("user_id") val userId: Int,
    @SerializedName("empresa") val empresa: String,
    @SerializedName("estado_id") val estadoId: Int
)