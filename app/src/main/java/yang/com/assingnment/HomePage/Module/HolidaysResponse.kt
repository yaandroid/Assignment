package yang.com.assingnment.HomePage.Module

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName



/**
 * Created by yang on 23/10/18.
 */
class HolidaysResponse {

    @SerializedName("success")
    @Expose
     val success: Boolean? = null
    @SerializedName("msg")
    @Expose
     val msg: String? = null
    @SerializedName("data")
    @Expose
     val data: Data? = null
}