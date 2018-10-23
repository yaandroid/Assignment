package yang.com.assingnment.Domain

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import java.io.Serializable


/**
 * Created by yang on 23/10/18.
 */
 class DomainResponse : Serializable {

    @SerializedName("success")
    @Expose
    private var success: Boolean? = null
    @SerializedName("msg")
    @Expose
    private var msg: String? = null
    @SerializedName("data")
    @Expose
    private var data: Data? = null

    fun getSuccess(): Boolean? {
        return success
    }

    fun setSuccess(success: Boolean?) {
        this.success = success
    }

    fun getMsg(): String? {
        return msg
    }

    fun setMsg(msg: String) {
        this.msg = msg
    }

    fun getData(): Data? {
        return data
    }

    fun setData(data: Data) {
        this.data = data
    }


}