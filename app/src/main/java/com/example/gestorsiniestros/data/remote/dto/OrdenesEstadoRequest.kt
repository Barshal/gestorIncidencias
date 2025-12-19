import com.google.gson.annotations.SerializedName

data class OrdenesEstadoRequest(

    @SerializedName("empresa") val empresa: String,
    @SerializedName("user_id") val userId: String
)