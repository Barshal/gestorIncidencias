package com.example.gestorsiniestros.model

import com.google.gson.annotations.SerializedName


data class OrdenEstado (

    @SerializedName("id"            ) var id           : Int?    = null,
    @SerializedName("orden_vis"     ) var ordenVis     : Int?    = null,
    @SerializedName("letra_estado"  ) var letraEstado  : String? = null,
    @SerializedName("texto_estado"  ) var textoEstado  : String? = null,
    @SerializedName("created_at"    ) var createdAt    : String? = null,
    @SerializedName("updated_at"    ) var updatedAt    : String? = null,
    @SerializedName("deleted_at"    ) var deletedAt    : String? = null,
    @SerializedName("ordenes_count" ) var ordenesCount : Int?    = null

)