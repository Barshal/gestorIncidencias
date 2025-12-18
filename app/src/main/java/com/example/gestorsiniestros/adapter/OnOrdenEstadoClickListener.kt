package com.example.gestorsiniestros.adapter

import com.example.gestorsiniestros.data.model.OrdenEstado

/**
 * Interfaz para comunicar eventos de clic desde el Adapter a la Activity.
 */
interface OnOrdenEstadoClickListener {
    //@param ordenEstado
    fun onItemClicked(ordenEstado: OrdenEstado)
}
