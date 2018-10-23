package yang.com.assingnment.Service

import com.google.gson.JsonObject
import io.reactivex.Observable
import okhttp3.MultipartBody
import retrofit2.http.*
import yang.com.assingnment.Domain.DomainResponse
import yang.com.assingnment.HomePage.Module.HolidaysResponse
import yang.com.assingnment.Register.Module.SuccessResp


/**
 * Created by yang on 09/02/18.
 */


interface ApiService {

    /*static let DomainsList = "domains"
    static let CreateUser = "register"
    static let LoginAccess = "login"
    static let QRCodeScan = "attendance/mark"
    static let ListOfHolidays = "holidays"*/

    @Headers("Content-Type: application/json ")
    @POST("/api/login")
    fun getLoginAccess(@Body jsonObject: JsonObject): Observable<SuccessResp>

    @POST("/api/attendance/mark")
    fun getUserAttendance(@Body jsonObject: JsonObject): Observable<SuccessResp>

    @GET("/api/holidays")
    fun getUserholidays(): Observable<HolidaysResponse>


    @GET("/api/domains")
    fun domains(): Observable<DomainResponse>

    @Headers("Content-Type: application/json")
    @POST("/api/register")
    fun getRegisterAccess(@Body jsonObject: JsonObject)
            : Observable<SuccessResp>

}