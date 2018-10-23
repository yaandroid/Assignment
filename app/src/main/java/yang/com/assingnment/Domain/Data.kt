package yang.com.assingnment.Domain

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName


/**
 * Created by yang on 23/10/18.
 */
class Data {
    @SerializedName("domains")
    @Expose
    private var domains: ArrayList<Domain>? = null

    fun getDomains(): ArrayList<Domain>? {
        return domains
    }

    fun setDomains(domains: ArrayList<Domain>) {
        this.domains = domains
    }


}