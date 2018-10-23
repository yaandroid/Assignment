package yang.com.assingnment.Login

import com.google.gson.JsonObject
import org.json.JSONObject
import yang.com.assingnment.Register.Module.SuccessResp

interface LoginResponse {
    fun errorResponse(error :String )
    fun LoginSuccessResponse(result : SuccessResp)

}