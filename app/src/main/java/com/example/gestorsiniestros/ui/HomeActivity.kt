package com.example.gestorsiniestros.ui

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.gestorsiniestros.adapter.OnOrdenEstadoClickListener
import com.example.gestorsiniestros.adapter.OrdenResumenAdapter
import com.example.gestorsiniestros.data.model.OrdenEstado
import com.example.gestorsiniestros.databinding.ActivityHomeBinding
import com.example.gestorsiniestros.viewmodel.HomeViewModel

class HomeActivity : AppCompatActivity(), OnOrdenEstadoClickListener {

    private lateinit var binding: ActivityHomeBinding
    private lateinit var adapterOrdenEstado: OrdenResumenAdapter

    // Inyecta el ViewModel usando la dependencia de activity-ktx
    private val homeViewModel: HomeViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        instancias()
        initGUI()
        setupEventListeners()
        observadores()

        homeViewModel.cargarOrdenes()
    }

    private fun instancias() {
        // Inicializa el adaptador con una lista vacía. El ViewModel la llenará.
        adapterOrdenEstado = OrdenResumenAdapter(emptyList(), this)
    }

    private fun initGUI() {
        binding.recyclerOrdenEstado.adapter = adapterOrdenEstado
        binding.recyclerOrdenEstado.layoutManager =
            LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
    }

    private fun setupEventListeners() {
        binding.btnDescargar.setOnClickListener {
            // TODO: Lógica para el botón Descargar
            Toast.makeText(this, "Botón Descargar pulsado", Toast.LENGTH_SHORT).show()
        }

        binding.btnEntrar.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

        binding.btnSuper.setOnClickListener {
            // TODO: Lógica para el botón Super
            Toast.makeText(this, "Botón Super pulsado", Toast.LENGTH_SHORT).show()
        }

        binding.btnCitas.setOnClickListener {
            // TODO: Lógica para el botón Citas
            Toast.makeText(this, "Botón Citas pulsado", Toast.LENGTH_SHORT).show()
        }

        binding.btnBuscar.setOnClickListener {
            // TODO: Lógica para el botón Buscar
            Toast.makeText(this, "Botón Buscar pulsado", Toast.LENGTH_SHORT).show()
        }

        binding.btnCargar.setOnClickListener {
            homeViewModel.cargarOrdenes()
            Toast.makeText(this, "Recargando lista...", Toast.LENGTH_SHORT).show()
        }
    }

    private fun observadores() {
        // Observa los cambios en la lista de órdenes
        homeViewModel.ordenes.observe(this) { listaOrdenes ->
            // Actualiza el adaptador del RecyclerView con la nueva lista
            adapterOrdenEstado.actualizarLista(listaOrdenes)
        }
    }

    // 5. Metodo que se ejecuta cuando el boton es pulsado, no se si este es el mejor sitio para esto
    override fun onItemClicked(ordenEstado: OrdenEstado) {
        // Creamos un Intent para lanzar la nueva Activity.
        val intent = Intent(this, ListaOrdenesActivity::class.java)

        // Pasamos datos a la nueva Activity para que sepa qué mostrar.
        intent.putExtra("estado", ordenEstado.id)
        intent.putExtra("userId", 7)
        intent.putExtra("empresaId", "001")


        // Lanzamos la Activity.
        startActivity(intent)
    }
}
