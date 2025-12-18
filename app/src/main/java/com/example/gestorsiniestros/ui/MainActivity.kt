package com.example.gestorsiniestros.ui

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.example.gestorsiniestros.databinding.ActivityMainBinding
import com.example.gestorsiniestros.viewmodel.LoginResult
import com.example.gestorsiniestros.viewmodel.LoginViewModel

class MainActivity : AppCompatActivity() {
    //1 Creamos el binding
    private lateinit var binding: ActivityMainBinding // No inicializar aquí. Lo haremos más tarde.
    private val loginViewModel: LoginViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setupEventListeners()
        setupObservers()
    }

    // 2. La Vista solo notifica la acción del usuario al ViewModel
    private fun setupEventListeners() {
        binding.btnAcceder.setOnClickListener {
            val user = binding.editTextUser.text.toString()
            val pass = binding.etPassword.text.toString()
            loginViewModel.onLoginClicked(user, pass)
        }
    }

    // 3. La Vista observa los cambios de LiveData y actualiza la UI
    private fun setupObservers() {
        loginViewModel.loginResult.observe(this) { result ->
            when (result) {
                is LoginResult.Success -> {
                    // Éxito -> Navegar a HomeActivity
                    Toast.makeText(this, "Acceso concedido", Toast.LENGTH_SHORT).show()
                    val intent = Intent(this, HomeActivity::class.java)
                    startActivity(intent)
                    finish()
                }

                is LoginResult.Error -> {
                    Toast.makeText(this, result.message, Toast.LENGTH_LONG).show()
                }
            }
        }
    }
}