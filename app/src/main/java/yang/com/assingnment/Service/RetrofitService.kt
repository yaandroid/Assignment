package yang.com.assingnment.Service

import android.util.Log
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import yang.com.assingnment.Utils.Utils
import yang.com.assingnment.Utils.Utils.Companion.RC_SIGN_IN
import java.io.IOException
import java.util.concurrent.TimeUnit


/**
 * Created by yang
 */
class RetrofitService {


    fun createRetrofit(): ApiService {
//        val httpClient = OkHttpClient.Builder()
//        httpClient.addNetworkInterceptor(AddHeaderInterceptor())

        val logging = HttpLoggingInterceptor()
        logging.level = HttpLoggingInterceptor.Level.BODY
        val httpClient = OkHttpClient.Builder()
                .connectTimeout(60.toLong(), TimeUnit.SECONDS)
                .addNetworkInterceptor(AddHeaderInterceptor())
                .readTimeout(60.toLong(), TimeUnit.SECONDS)
                .addInterceptor(logging)
                .build()


        val retrofit = Retrofit.Builder()
                .addCallAdapterFactory(
                        RxJava2CallAdapterFactory.create())
                .addConverterFactory(
                        GsonConverterFactory.create())
                .baseUrl(Utils().BASE_URL)
                .client(httpClient)
                .build()
        Log.v("create Retrofit  ", " BASE_URL url " + Utils().BASE_URL)

        return retrofit.create(ApiService::class.java)
    }

    inner class AddHeaderInterceptor : Interceptor {
        @Throws(IOException::class)
        override fun intercept(chain: Interceptor.Chain): okhttp3.Response {

            val builder = chain.request().newBuilder()
            builder.addHeader("token", RC_SIGN_IN)
            Log.v("addHeader ", "addHeader $RC_SIGN_IN")
//            builder.addHeader("X-Auth-User-Token", "XfHvI1dGz5e7XmXPicVpt0ROUL0")
//            builder.addHeader("Content-Type", "application/x-www-form-urlencoded")

            return chain.proceed(builder.build())
        }
    }


}