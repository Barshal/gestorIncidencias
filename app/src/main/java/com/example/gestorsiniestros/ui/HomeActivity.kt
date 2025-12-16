package com.example.gestorsiniestros.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.gestorsiniestros.adapter.OrdenResumenAdapter
import com.example.gestorsiniestros.databinding.ActivityHomeBinding
import com.example.gestorsiniestros.model.OrdenEstado


class HomeActivity : AppCompatActivity(), OrdenResumenAdapter.OnItemClickListener {

    private lateinit var binding: ActivityHomeBinding
    private lateinit var adapterOrdenEstado: OrdenResumenAdapter
    private lateinit var lista: List<OrdenEstado> // Instacion la lista

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)
        instancias()
        initGUI()
    }

    //Asociamos el adaptador al recycler
    private fun initGUI() {
        binding.recyclerOrdenEstado.adapter = adapterOrdenEstado
        binding.recyclerOrdenEstado.layoutManager =
            LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
    }

    private fun instancias() {
        lista = arrayListOf(
            OrdenEstado(id=1, ordenVis=1, letraEstado="S", textoEstado="PTE. ASUMIR", createdAt="2025-08-20T09:44:13.000000Z", updatedAt=null, deletedAt=null, ordenesCount=5),
            OrdenEstado(id=2, ordenVis=2, letraEstado="Q", textoEstado="PTE. CITAR MEDIR", createdAt="2025-08-20T09:44:13.000000Z", updatedAt=null, deletedAt=null, ordenesCount=1),
            OrdenEstado(id=3, ordenVis=3, letraEstado="M", textoEstado="PTE. MEDICIÓN", createdAt="2025-08-20T09:44:13.000000Z", updatedAt=null, deletedAt=null, ordenesCount=1),
            OrdenEstado(id=4, ordenVis=4, letraEstado="G", textoEstado="PTE. GESTIÓN", createdAt="2025-08-20T09:44:13.000000Z", updatedAt=null, deletedAt=null, ordenesCount=0),
            OrdenEstado(id=5, ordenVis=5, letraEstado="P", textoEstado="PTE. PRESUPUESTO", createdAt="2025-08-20T09:44:13.000000Z", updatedAt=null, deletedAt=null, ordenesCount=0),
            OrdenEstado(id=6, ordenVis=6, letraEstado="A", textoEstado="PTE. ACEPTACIÓN", createdAt="2025-08-20T09:44:13.000000Z", updatedAt=null, deletedAt=null, ordenesCount=0),
            OrdenEstado(id=7, ordenVis=7, letraEstado="V", textoEstado="PTE. PROVEEDOR", createdAt="2025-08-20T09:44:13.000000Z", updatedAt=null, deletedAt=null, ordenesCount=0),
            OrdenEstado(id=8, ordenVis=8, letraEstado="T", textoEstado="PTE. TALLER", createdAt="2025-08-20T09:44:13.000000Z", updatedAt=null, deletedAt=null, ordenesCount=0),
            OrdenEstado(id=17, ordenVis=9, letraEstado="W", textoEstado="PTE. CITAR MONTAR", createdAt="2025-08-20T09:44:13.000000Z", updatedAt=null, deletedAt=null, ordenesCount=0),
            OrdenEstado(id=10, ordenVis=10, letraEstado="I", textoEstado="PTE. MONTAJE", createdAt="2025-08-20T09:44:13.000000Z", updatedAt=null, deletedAt=null, ordenesCount=0),
            OrdenEstado(id=11, ordenVis=11, letraEstado="B", textoEstado="PTE. ALBARANEAR", createdAt="2025-08-20T09:44:13.000000Z", updatedAt=null, deletedAt=null, ordenesCount=0),
            OrdenEstado(id=12, ordenVis=12, letraEstado="F", textoEstado="PTE. FACTURAR", createdAt="2025-08-20T09:44:13.000000Z", updatedAt=null, deletedAt=null, ordenesCount=0),
            OrdenEstado(id=13, ordenVis=13, letraEstado="D", textoEstado="FACTURADO", createdAt="2025-08-20T09:44:13.000000Z", updatedAt=null, deletedAt=null, ordenesCount=0),
            OrdenEstado(id=14, ordenVis=14, letraEstado="C", textoEstado="COBRADO", createdAt="2025-08-20T09:44:13.000000Z", updatedAt=null, deletedAt=null, ordenesCount=0),
            OrdenEstado(id=15, ordenVis=15, letraEstado="L", textoEstado="CANCELADO", createdAt="2025-08-20T09:44:13.000000Z", updatedAt=null, deletedAt=null, ordenesCount=0),
            OrdenEstado(id=16, ordenVis=16, letraEstado="N", textoEstado="NO ACEPTADO", createdAt="2025-08-20T09:44:13.000000Z", updatedAt=null, deletedAt=null, ordenesCount=0)
        )
        // La línea 51 ahora es correcta porque HomeActivity cumple con la interfaz.
        adapterOrdenEstado = OrdenResumenAdapter(lista, this, this)
    }

    override fun onItemClick(ordenEstado: OrdenEstado) {
        android.widget.Toast.makeText(
            this,
            "Has presionado: ${ordenEstado.textoEstado}",
            android.widget.Toast.LENGTH_SHORT
        ).show()
    }


}