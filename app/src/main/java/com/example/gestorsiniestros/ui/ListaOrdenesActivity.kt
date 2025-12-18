package com.example.gestorsiniestros.ui

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.gestorsiniestros.R
import com.example.gestorsiniestros.databinding.ActivityListaOrdenesBinding
import com.example.gestorsiniestros.databinding.ActivityMainBinding

class ListaOrdenesActivity : AppCompatActivity() {
    private lateinit var binding: ActivityListaOrdenesBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityListaOrdenesBinding.inflate(layoutInflater)
        setContentView(binding.root)

    }
}