package com.example.gestorsiniestros.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.gestorsiniestros.model.OrdenEstado

class HomeViewModel : ViewModel() {
    private val _ordenes = MutableLiveData<List<OrdenEstado>>()
    val ordenes: LiveData<List<OrdenEstado>> = _ordenes

    // Función que se llamará desde la Activity para pedir los datos.
    fun onViewCreated() {
        // En un futuro, aquí llamarías a un Repositorio para obtener datos de una API o DB.
        // Por ahora, creamos los datos de prueba.
        val dummyList = createDummyData()
        _ordenes.value = dummyList // Asignamos la lista al LiveData, lo que notificará a la Activity.
    }

    // Lógica para manejar clics
    fun onCategoryClicked(ordenEstado: OrdenEstado) {
        println("ViewModel ha sido notificado del clic en: ${ordenEstado.textoEstado}")
    }

    // Esto habrá que quitarlo en un futuro, solo para probar.
    private fun createDummyData(): List<OrdenEstado> {
        return  arrayListOf(
            OrdenEstado(id=1, ordenVis=1, letraEstado="S", textoEstado="PTE. ASUMIR", createdAt="2025-08-20T09:44:13.000000Z", updatedAt=null, deletedAt=null, ordenesCount=5),
            OrdenEstado(id=2, ordenVis=2, letraEstado="Q", textoEstado="PTE. CITAR MEDIR", createdAt="2025-08-20T09:44:13.000000Z", updatedAt=null, deletedAt=null, ordenesCount=1),
            OrdenEstado(id=3, ordenVis=3, letraEstado="M", textoEstado="PTE. MEDICIÓN", createdAt="2025-08-20T09:44:13.000000Z", updatedAt=null, deletedAt=null, ordenesCount=1),
            OrdenEstado(id=4, ordenVis=4, letraEstado="G", textoEstado="PTE. GESTIÓN", createdAt="2025-08-20T09:44:13.000000Z", updatedAt=null, deletedAt=null, ordenesCount=10),
            OrdenEstado(id=5, ordenVis=5, letraEstado="P", textoEstado="PTE. PRESUPUESTO", createdAt="2025-08-20T09:44:13.000000Z", updatedAt=null, deletedAt=null, ordenesCount=4),
            OrdenEstado(id=6, ordenVis=6, letraEstado="A", textoEstado="PTE. ACEPTACIÓN", createdAt="2025-08-20T09:44:13.000000Z", updatedAt=null, deletedAt=null, ordenesCount=0),
            OrdenEstado(id=7, ordenVis=7, letraEstado="V", textoEstado="PTE. PROVEEDOR", createdAt="2025-08-20T09:44:13.000000Z", updatedAt=null, deletedAt=null, ordenesCount=3),
            OrdenEstado(id=8, ordenVis=8, letraEstado="T", textoEstado="PTE. TALLER", createdAt="2025-08-20T09:44:13.000000Z", updatedAt=null, deletedAt=null, ordenesCount=0),
            OrdenEstado(id=17, ordenVis=9, letraEstado="W", textoEstado="PTE. CITAR MONTAR", createdAt="2025-08-20T09:44:13.000000Z", updatedAt=null, deletedAt=null, ordenesCount=1),
            OrdenEstado(id=10, ordenVis=10, letraEstado="I", textoEstado="PTE. MONTAJE", createdAt="2025-08-20T09:44:13.000000Z", updatedAt=null, deletedAt=null, ordenesCount=0),
            OrdenEstado(id=11, ordenVis=11, letraEstado="B", textoEstado="PTE. ALBARANEAR", createdAt="2025-08-20T09:44:13.000000Z", updatedAt=null, deletedAt=null, ordenesCount=3),
            OrdenEstado(id=12, ordenVis=12, letraEstado="F", textoEstado="PTE. FACTURAR", createdAt="2025-08-20T09:44:13.000000Z", updatedAt=null, deletedAt=null, ordenesCount=5),
            OrdenEstado(id=13, ordenVis=13, letraEstado="D", textoEstado="FACTURADO", createdAt="2025-08-20T09:44:13.000000Z", updatedAt=null, deletedAt=null, ordenesCount=0),
            OrdenEstado(id=14, ordenVis=14, letraEstado="C", textoEstado="COBRADO", createdAt="2025-08-20T09:44:13.000000Z", updatedAt=null, deletedAt=null, ordenesCount=0),
            OrdenEstado(id=15, ordenVis=15, letraEstado="L", textoEstado="CANCELADO", createdAt="2025-08-20T09:44:13.000000Z", updatedAt=null, deletedAt=null, ordenesCount=9),
            OrdenEstado(id=16, ordenVis=16, letraEstado="N", textoEstado="NO ACEPTADO", createdAt="2025-08-20T09:44:13.000000Z", updatedAt=null, deletedAt=null, ordenesCount=0)
        )
    }
}
