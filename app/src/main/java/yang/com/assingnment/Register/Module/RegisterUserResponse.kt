package yang.com.assingnment.Register.Module

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class RegisterUserResponse {

    @SerializedName("success")
    @Expose
    val success: Boolean? = null
    @SerializedName("userTempId")
    @Expose
    val userTempId: Int? = null
    @SerializedName("session_id")
    @Expose
    val sessionId: String? = null

    @SerializedName("fail")
    @Expose
    var fail: Boolean? = null
    @SerializedName("errors")
    @Expose
    var errors: Errors? = null

    @SerializedName("user")
    @Expose
    var user: User? = null

//    @SerializedName("user_id")
//    @Expose
//    private val userId: Int? = null

    //fail // errors

     class Errors {
        @Expose
        private val email: List<String>? = null
        @SerializedName("password")
        @Expose
        private val password: List<String>? = null
    }
}
