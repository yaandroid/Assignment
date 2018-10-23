package yang.com.assingnment.Register.Module

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName



/**
 * Created by yang on 23/10/18.
 */
class Data {
    @SerializedName("token")
    @Expose
     var token: String? = null
    @SerializedName("permission")
    @Expose
    private var permission: String? = null
}