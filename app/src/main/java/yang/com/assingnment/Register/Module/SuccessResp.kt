package yang.com.assingnment.Register.Module

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName



/**
 * Created by yang on 23/10/18.
 */
class SuccessResp {


    @SerializedName("success")
    @Expose
     var success: Boolean? = null
    @SerializedName("msg")
    @Expose
     var msg: String? = null
    @SerializedName("data")
    @Expose
     var data: Data? = null


}