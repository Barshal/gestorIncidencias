package com.example.gestorsiniestros.data.model

import com.google.gson.annotations.SerializedName

data class OrdenResumen(

    @SerializedName("id") val id: Int?,
    @SerializedName("siniestro_id") val siniestroId: Int?,
    @SerializedName("gremio_id") val gremioId: Int?,
    @SerializedName("fh_apertura") val fechaApertura: String?,
    @SerializedName("fh_reapertura") val fechaReapertura: String?,
    @SerializedName("estado_orden_id") val estadoOrdenId: Int?,
    @SerializedName("dom_orden") val domicilioOrden: String?,
    @SerializedName("pob_orden") val poblacionOrden: String?,
    @SerializedName("cpostal_orden") val codigoPostal: String?,
    @SerializedName("prov_orden") val provinciaOrden: String?,
    @SerializedName("orden_abierta") val ordenAbierta: Int?,
    @SerializedName("fh_recogido_montar") val fechaRecogidoMontaje: String?,
    @SerializedName("num_operarios_necesarios") val numOperariosNecesarios: Int?,
    @SerializedName("proveedor_id") val proveedorId: Int?,
    @SerializedName("imp_desplaz")val importeDesplazamiento: String?,
    @SerializedName("bimp_fact") val baseImponibleFactura: String?,
    @SerializedName("porc_iva_fact") val porcentajeIvaFactura: String?,
    @SerializedName("created_at") val createdAt: String?,
    @SerializedName("updated_at") val updatedAt: String?,
    @SerializedName("deleted_at") val deletedAt: String?

)
