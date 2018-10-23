package yang.com.assingnment.Register.Module

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class User {

    @SerializedName("domainID")
    @Expose
    var domainID: Int? = null
    @SerializedName("id")
    @Expose
    var id: Int? = null
    @SerializedName("name")
    @Expose
    var name: String? = null
    @SerializedName("password")
    @Expose
    var password: String? = null

    @SerializedName("email")
    @Expose
    var email: String? = null
    @SerializedName("phone")
    @Expose
    var phone: String? = null
    @SerializedName("country_id")
    @Expose
    var countryId: Int? = null
    @SerializedName("state_id")
    @Expose
    var stateId: Int? = null
    @SerializedName("city_id")
    @Expose
    var cityId: Int? = null
    @SerializedName("area_id")
    @Expose
    var areaId: Int? = null
    @SerializedName("pincode")
    @Expose
    var pincode: String? = null
    @SerializedName("facebook_id")
    @Expose
    var facebookId: String? = null
    @SerializedName("google_id")
    @Expose
    var googleId: String? = null
    @SerializedName("device_id")
    @Expose
    var deviceId: String? = null
    @SerializedName("verified_status")
    @Expose
    var verifiedStatus: Int? = null
    @SerializedName("country")
    @Expose
    var country: Any? = null
    @SerializedName("state")
    @Expose
    var state: Any? = null
    @SerializedName("city")
    @Expose
    var city: Any? = null
    @SerializedName("area")
    @Expose
    var area: Any? = null
    @SerializedName("mobile_number")
    @Expose
    val mobileNumber: String? = null
    @SerializedName("age")
    @Expose
    val age: String? = null
    @SerializedName("gender")
    @Expose
    val gender: String? = null
    @SerializedName("dob")
    @Expose
    val dob: String? = null
    @SerializedName("anniversary_dt")
    @Expose
    val anniversaryDt: String? = null
    @SerializedName("address")
    @Expose
    val address: String? = null
    @SerializedName("ref_by")
    @Expose
    val refBy: String? = null
    @SerializedName("profile_picture")
    @Expose
    val profilePicture: Any? = null
    @SerializedName("created_dt")
    @Expose
    val createdDt: String? = null
    @SerializedName("created_by")
    @Expose
    val createdBy: String? = null
    @SerializedName("modified_dt")
    @Expose
    val modifiedDt: String? = null
    @SerializedName("status_closed_dt")
    @Expose
    val statusClosedDt: Any? = null
    @SerializedName("patient_ref_number")
    @Expose
    val patientRefNumber: String? = null
    @SerializedName("location")
    @Expose
    val location: String? = null
    @SerializedName("language")
    @Expose
    val language: String? = null
    @SerializedName("api_access_token")
    @Expose
    val apiAccessToken: String? = null


}
