package com.example.gestorsiniestros.ui

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.gestorsiniestros.R
import com.example.gestorsiniestros.adapter.OrdenResumenAdapter
import com.example.gestorsiniestros.adapter.OrdenTrabajoResumenAdapter
import com.example.gestorsiniestros.data.model.OrdenEstado
import com.example.gestorsiniestros.data.model.OrdenResumen
import com.example.gestorsiniestros.databinding.ActivityListaOrdenesBinding
import com.example.gestorsiniestros.databinding.ActivityMainBinding

class ListaOrdenesActivity : AppCompatActivity() {
    private lateinit var binding: ActivityListaOrdenesBinding
    private lateinit var adapterOtResumen: OrdenTrabajoResumenAdapter
    private lateinit var lista: ArrayList<OrdenResumen>


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityListaOrdenesBinding.inflate(layoutInflater)
        setContentView(binding.root)
        instancias()
        initGUI()
    }

    private fun initGUI() {
        binding.recyclerOrdenEstado.adapter = adapterOtResumen
        binding.recyclerOrdenEstado.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)

    }

    private fun instancias() {
        val lista = arrayListOf(
            OrdenResumen(1, 3, 15, "2025-10-21 15:16:00", "2025-11-28 20:12:17", 1, "C/Falsa, 8", "MADRID", "28041", "MADRID", 1, null, 4, null, "0.00", "0.00", "0.00", "2025-10-21T13:17:05.000000Z", "2025-12-18T10:57:27.000000Z", null),
            OrdenResumen(3, 2, 15, "2025-11-03 16:25:00", "2025-11-01 20:12:17", 1, null, null, null, null, 1, null, 1, null, "0.00", "0.00", "0.00", "2025-11-03T15:25:23.000000Z", "2025-12-18T10:57:27.000000Z", null),
            OrdenResumen(4, 2, 15, "2025-11-03 17:33:00", "2025-11-27 20:12:17", 1, "ESTRELLA NAOS 2 6A", "MADRID", "28045", "MADRID", 1, "2025-11-03 17:33:00", 1, null, "0.00", "0.00", "0.00", "2025-11-03T16:34:04.000000Z", "2025-12-18T10:57:27.000000Z", null),
            OrdenResumen(5, 3, 15, "2025-11-06 09:51:00", "2025-11-29 20:12:17", 1, "AV.EXTREMADURA 63", "FUENLABRADA", "28944", "MADRID", 1, null, 1, null, "0.00", "0.00", "0.00", "2025-11-06T09:03:00.000000Z", "2025-12-18T10:57:27.000000Z", null),
            OrdenResumen(6, 3, 15, "2025-11-06 09:51:00", "2025-10-25 20:12:17", 1, "AV.EXTREMADURA 63", "FUENLABRADA", "28944", "MADRID", 1, null, 1, null, "0.00", "0.00", "0.00", "2025-11-06T09:03:46.000000Z", "2025-12-18T10:57:27.000000Z", null)
        )
        adapterOtResumen = OrdenTrabajoResumenAdapter(lista, this)
        binding.recyclerOrdenEstado.adapter = adapterOtResumen


    }
}