package com.example.gestorsiniestros.ui

import HomeViewModel
import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.gestorsiniestros.adapter.OrdenResumenAdapter
import com.example.gestorsiniestros.databinding.ActivityHomeBinding

class HomeActivity : AppCompatActivity() {

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
        observadores()

        // Pide al ViewModel que cargue los datos
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

    private fun observadores() {
        // Observa los cambios en la lista de órdenes
        homeViewModel.ordenes.observe(this) { listaOrdenes ->
            // Actualiza el adaptador del RecyclerView con la nueva lista
            adapterOrdenEstado.actualizarLista(listaOrdenes)
        }

        // (Opcional) Observa el estado de carga para mostrar/ocultar un ProgressBar
        homeViewModel.isLoading.observe(this) { estaCargando ->
            // if (estaCargando) binding.progressBar.visibility = View.VISIBLE
            // else binding.progressBar.visibility = View.GONE
        }
    }
}
