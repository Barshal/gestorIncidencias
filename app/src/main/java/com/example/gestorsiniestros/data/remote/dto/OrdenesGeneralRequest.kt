import com.google.gson.annotations.SerializedName

data class OrdenesGeneralRequest(

    @SerializedName("empresa")
    val empresa: String,

    @SerializedName("user_id")
    val userId: String
)