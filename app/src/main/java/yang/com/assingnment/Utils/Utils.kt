package yang.com.assingnment.Utils

import android.content.Context
import android.net.ConnectivityManager
import android.widget.EditText
import android.widget.Toast
import yang.com.assingnment.Domain.DomainResponse
import java.util.*
import java.util.Calendar.*
import java.util.regex.Pattern


/**
 * Created by yang .
 *
 */
class Utils {

    val BASE_URL = "http://13.127.73.24/"

    companion object {

        fun checkConnection(context: Context): Boolean {
            val connMgr = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager

            val activeNetworkInfo = connMgr.activeNetworkInfo

            if (activeNetworkInfo != null) { // connected to the internet

                if (activeNetworkInfo.type == ConnectivityManager.TYPE_WIFI) {
                    // connected to wifi
                    return true
                } else if (activeNetworkInfo.type == ConnectivityManager.TYPE_MOBILE) {
                    // connected to the mobile provider's data plan
                    return true
                }
            }
            return false
        }

        var RC_SIGN_IN = ""

        fun isEmailValid(email: EditText): Boolean {

            if (email.text.toString().trim().isEmpty()) {
                email.error = "Please enter valid email!"
                return false
            } else {
                return Pattern.compile(
                        "^(([\\w-]+\\.)+[\\w-]+|([a-zA-Z]|[\\w-]{2,}))@"
                                + "((([0-1]?[0-9]{1,2}|25[0-5]|2[0-4][0-9])\\.([0-1]?"
                                + "[0-9]{1,2}|25[0-5]|2[0-4][0-9])\\."
                                + "([0-1]?[0-9]{1,2}|25[0-5]|2[0-4][0-9])\\.([0-1]?"
                                + "[0-9]{1,2}|25[0-5]|2[0-4][0-9]))|"
                                + "([a-zA-Z]+[\\w-]+\\.)+[a-zA-Z]{2,4})$"
                ).matcher(email.text.toString().trim()).matches()
            }

        }

        internal enum class Status constructor(val key: String, val value: Int?) {

            ACTIVE("Active", 1), IN_ACTIVE("In Active", 2)
        }

        enum class CAT_TYPES {
            tips, story, testimonial
        }

        fun getDiffYears(first: Date, last: Date): Int {
            val a = getCalendar(first)
            val b = getCalendar(last)
            var diff = b.get(YEAR) - a.get(YEAR)
            if (a.get(MONTH) > b.get(MONTH) || a.get(MONTH) === b.get(MONTH) && a.get(DATE) > b.get(DATE)) {
                diff--
            }
            return diff
        }

        fun getCalendar(date: Date): Calendar {
            val cal = Calendar.getInstance(Locale.US)
            cal.time = date
            return cal
        }


        var domainResponse: DomainResponse? = null
        val DomainName: ArrayList<String> = ArrayList()
        val DomainId: ArrayList<Int> = ArrayList()


        fun destroyValue(){
            domainResponse=null
            DomainName.clear()
            DomainId.clear()
        }
    }


    val LoginUserSession = "UserCreateSession"

//    fun isEmailValid(email: String): Boolean {
//        val expression = "^[\\w\\.-]+@([\\w\\-]+\\.)+[A-Z]{2,4}$"
//        val pattern = Pattern.compile(expression, Pattern.CASE_INSENSITIVE)
//        val matcher = pattern.matcher(email)
//        return matcher.matches()
//    }


    fun showToast(context: Context, msg: String) {
        Toast.makeText(context, msg, Toast.LENGTH_LONG).show()
    }

    /*fun loadThumbnailImage(activity: Activity, imageView: ImageView, image_url: String) {
        val options = RequestOptions()
                .centerCrop()
                .placeholder(R.mipmap.ic_launcher_round)
                .error(R.mipmap.ic_launcher_round)



        Glide.with(activity).load(image_url).apply(options).into(imageView)
    }

    fun loadFullImage(activity: Activity, imageView: ImageView, image_url: String) {
        val options = RequestOptions()
                .centerCrop()
                .placeholder(R.mipmap.ic_launcher_round)
                .error(R.mipmap.ic_launcher_round)
        Glide.with(activity).load(image_url).apply(options).into(imageView)
    }*/

    /** CHECK WHETHER INTERNET CONNECTION IS AVAILABLE OR NOT  */

}