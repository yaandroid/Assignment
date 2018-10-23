package yang.com.assingnment.HomePage.Module

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName



/**
 * Created by yang on 23/10/18.
 */
class Holiday {

    @SerializedName("title")
    @Expose
     val title: String? = null
    @SerializedName("date")
    @Expose
     val date: String? = null
    @SerializedName("description")
    @Expose
     val description: String? = null
    @SerializedName("image")
    @Expose
     val image: String? = null
}