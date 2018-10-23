package yang.com.assingnment.Register.Module

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName



/**
 * Created by yang on 01/03/18.
 */
class SuccessResponse {
    @SerializedName("success")
    @Expose
     val success: Boolean? = null

    @SerializedName("fail")
    @Expose
    val fail: Boolean? = null

    @SerializedName("errors")
    @Expose
    val errors: String? = null
}