package com.example.gestorsiniestros

import android.os.Bundle
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.gestorsiniestros.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), View.OnClickListener {
    // Creamo el binding
    private lateinit var binding: ActivityMainBinding // No inicializar aquí. Lo haremos más tarde.




    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Despues de esta linea puedo hacer lo que quiera con los elementos gráficos del layout

    }
    private fun acciones(){

        binding.btnAcceder.setOnClickListener(this)
        binding.cbRecordarUsuario.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when(v!!.id){
            binding.btnAcceder.id -> {}
            binding.cbRecordarUsuario.id -> {}
        }
    }
}