package com.example.gestorsiniestros.ui

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.gestorsiniestros.adapter.OrdenTrabajoResumenAdapter
import com.example.gestorsiniestros.data.remote.dto.OrdenesResumenRequest
import com.example.gestorsiniestros.databinding.ActivityListaOrdenesBinding
import com.example.gestorsiniestros.viewmodel.ListaOrdenesViewModel

class ListaOrdenesActivity : AppCompatActivity() {
    //Vinculacion de vista con Binding
    private lateinit var binding: ActivityListaOrdenesBinding
    private val viewModel: ListaOrdenesViewModel by viewModels()
    private lateinit var adaptadorOrdenesResumen: OrdenTrabajoResumenAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityListaOrdenesBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val estadoId = intent.getStringExtra("estadoId")

        // Creamos el objeto request con los datos del Intent
        val request = OrdenesResumenRequest(
            userId = intent.getIntExtra("userId",7),
            empresa = intent.getStringExtra("empresaId") ?: "001",
            estadoId = intent.getIntExtra("estado", 0)
        )

        // Llamamos al ViewModel para que inicie la carga de datos
        viewModel.cargarOrdenesTrabajoResumen(request)

        // 1. Inicializamos la UI
        initUI()
        // 2. Configuramos los observadores del ViewModel
        initObservers()
    }


    private fun initUI() {
        // Inicializamos el adapater con una lista vacia
        adaptadorOrdenesResumen = OrdenTrabajoResumenAdapter(ArrayList(), this)
        // Configuramos el reciclerview
        binding.recyclerOrdenEstado.apply {
            adapter = adaptadorOrdenesResumen
            layoutManager = LinearLayoutManager(this@ListaOrdenesActivity)
        }
    }

    private fun initObservers() {
        // Observador para la lista de órdenes de trabajo
        viewModel.uiState.observe(this) { listaOrdenes ->
            // Cuando lleguen los datos, los enviamos al adapter
            adaptadorOrdenesResumen.actualizarLista(listaOrdenes)
        }

    }

}
