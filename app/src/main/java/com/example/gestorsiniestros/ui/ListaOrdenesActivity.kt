package com.example.gestorsiniestros.ui

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.gestorsiniestros.adapter.OrdenTrabajoResumenAdapter
import com.example.gestorsiniestros.data.model.OrdenResumen
import com.example.gestorsiniestros.data.remote.dto.OrdenesResumenRequest
import com.example.gestorsiniestros.databinding.ActivityListaOrdenesBinding
import com.example.gestorsiniestros.viewmodel.ListaOrdenesViewModel

class ListaOrdenesActivity : AppCompatActivity() {
    //Vinculacion de vista con Binding
    private lateinit var binding: ActivityListaOrdenesBinding
    private val viewModel: ListaOrdenesViewModel by viewModels()
    private lateinit var adaptadorOrdenesResumen: OrdenTrabajoResumenAdapter
    private lateinit var request: OrdenesResumenRequest

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityListaOrdenesBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Creamos el objeto request con los datos del Intent
        request = OrdenesResumenRequest(
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
        // 3. Configuramos los listeners de los botones
        setupEventListeners()
    }


    private fun initUI() {
        // Inicializamos el adapater con una lista vacia
        adaptadorOrdenesResumen = OrdenTrabajoResumenAdapter(ArrayList()) { orden ->
            navigateToDetail(orden)
        }
        // Configuramos el reciclerview
        binding.recyclerOrdenEstado.apply {
            adapter = adaptadorOrdenesResumen
            layoutManager = LinearLayoutManager(this@ListaOrdenesActivity)
        }
    }

    private fun navigateToDetail(orden: OrdenResumen) {
        val intent = Intent(this, DetalleOT::class.java)
        intent.putExtra("ordenId", orden.id)
        startActivity(intent)
    }

    private fun initObservers() {
        // Observador para la lista de órdenes de trabajo
        viewModel.uiState.observe(this) { listaOrdenes ->
            // Cuando lleguen los datos, los enviamos al adapter
            adaptadorOrdenesResumen.actualizarLista(listaOrdenes)
        }
    }

    private fun setupEventListeners() {
        binding.btnCargar.setOnClickListener {
            val intent = Intent(this, HomeActivity::class.java)
            startActivity(intent)
        }

        binding.btnDescargar.setOnClickListener {
            Toast.makeText(this, "Botón Descargar pulsado", Toast.LENGTH_SHORT).show()
        }

        binding.btnEntrar.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

        binding.btnSuper.setOnClickListener {
            Toast.makeText(this, "Botón Super pulsado", Toast.LENGTH_SHORT).show()
        }

        binding.btnCitas.setOnClickListener {
            Toast.makeText(this, "Botón Citas pulsado", Toast.LENGTH_SHORT).show()
        }

        binding.btnBuscar.setOnClickListener {
            Toast.makeText(this, "Botón Buscar pulsado", Toast.LENGTH_SHORT).show()
        }
    }
}
