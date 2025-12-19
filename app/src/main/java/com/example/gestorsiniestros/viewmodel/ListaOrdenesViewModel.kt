package com.example.gestorsiniestros.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.gestorsiniestros.data.model.OrdenResumen
import com.example.gestorsiniestros.data.remote.dto.OrdenesResumenRequest
import com.example.gestorsiniestros.domain.OrdenesRepository
import kotlinx.coroutines.launch

class ListaOrdenesViewModel : ViewModel() {
    // Instanciamos el preo donde están las llamadas a la API
    private val repository = OrdenesRepository()

    //......LiveData para obsevar el estado de la UI
    //1.- Creamos un livedata privado para que solo lo pueda cambiar el viewmodel
    private val _uiState = MutableLiveData<List<OrdenResumen>>()//privado
    val uiState: MutableLiveData<List<OrdenResumen>> get() = _uiState // Publico

    // LiveData para gestionar el estado de carga (mostrar/ocultar ProgressBar)
    private val _isLoading = MutableLiveData<Boolean>()
    val isLoading: LiveData<Boolean> get() = _isLoading

    // LiveData para comunicar errores a la UI (por ejemplo, para mostrar un Toast)
    private val _error = MutableLiveData<String?>()
    val error: LiveData<String?> get() = _error

    fun cargarOrdenesTrabajoResumen(filtro: OrdenesResumenRequest) {
        viewModelScope.launch {
            _isLoading.postValue(true) // notificacion de que la carga ha empezado
            try {
                val resultado = repository.getOrdenesTrabajoResumen(filtro)
                _uiState.postValue(resultado)
            } catch (e: Exception) {
                _error.postValue(e.message)
            } finally {
                _isLoading.postValue(false)
            }
        }
    }

    fun onErorMostrado() {
        _error.value = null
    }

}