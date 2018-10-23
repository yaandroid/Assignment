package yang.com.assingnment.Domain

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName



/**
 * Created by yang on 23/10/18.
 */
class Domain {

    @SerializedName("id")
    @Expose
     var id: Int? = null
    @SerializedName("domain")
    @Expose
     var domain: String? = null


}

