package com.example.gestorsiniestros.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class LoginViewModel : ViewModel() {

    // 1. LiveData para el estado de la UI (privado y mutable)
    private val _loginResult = MutableLiveData<LoginResult>()

    // 2. LiveData expuesto a la Vista (público e inmutable)
    val loginResult: LiveData<LoginResult> = _loginResult
    // Creo una instancia del adapter. Para inicializarlo necesito una lista y un contexto

    fun onLoginClicked(user: String, pass: String) {
        // Aquí va TODA la lógica de negocio que antes estaba en la Activity
        if (user.isEmpty() || pass.isEmpty()) {
            _loginResult.value = LoginResult.Error("Usuario y contraseña no pueden estar vacíos.")
            return
        }
        if (user == "000001" && pass == "7") {
            _loginResult.value = LoginResult.Success
        } else {
            _loginResult.value = LoginResult.Error("Credenciales incorrectas.")
        }
    }
}

// Clase sellada para representar los posibles resultados del login
sealed class LoginResult {
    object Success : LoginResult() // Éxito
    data class Error(val message: String) : LoginResult() // Error con un mensaje
}