package yang.com.assingnment.Register

import com.google.gson.JsonObject
import yang.com.assingnment.Register.Module.SuccessResp

/**
 * Created by yang on 22/02/18.
 */
interface RegisterResponse {
    fun SuccessResponse(userDetail: SuccessResp)
    fun ErrorResponse(error :String )
}