import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.gestorsiniestros.data.model.OrdenEstado
import com.example.gestorsiniestros.domain.OrdenesRepository
import kotlinx.coroutines.launch

class HomeViewModel : ViewModel() {

    private val repository = OrdenesRepository()
    private val _ordenes = MutableLiveData<List<OrdenEstado>>()
    val ordenes: LiveData<List<OrdenEstado>> = _ordenes

    private val _isLoading = MutableLiveData<Boolean>()
    val isLoading: LiveData<Boolean> = _isLoading

    // Función para cargar los datos desde la API
    fun cargarOrdenes() {
        viewModelScope.launch {
            _isLoading.value = true
            try {
                val filtroParaApi = OrdenesGeneralRequest(
                    empresa = "001",
                    userId = "7"
                )
                val listaOrdenes = repository.getOrdenesEstado(filtroParaApi)
                _ordenes.value = listaOrdenes
            } catch (e: Exception) {
                // Manejar el error (e.g., mostrar un mensaje)
                _ordenes.value = emptyList()
            } finally {
                _isLoading.value = false
            }
        }
    }
}
