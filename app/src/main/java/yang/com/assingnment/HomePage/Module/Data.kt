package yang.com.assingnment.HomePage.Module

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName



/**
 * Created by yang on 23/10/18.
 */
class Data {

    @SerializedName("holidays")
    @Expose
     val holidays: List<Holiday>? = null

}