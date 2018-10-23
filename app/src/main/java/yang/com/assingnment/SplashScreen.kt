package yang.com.assingnment

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.widget.Toast
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import yang.com.assingnment.Domain.DomainResponse
import yang.com.assingnment.Login.LoginActivity
import yang.com.assingnment.Service.RetrofitService
import yang.com.assingnment.Utils.Utils
import yang.com.assingnment.Utils.Utils.Companion.DomainId
import yang.com.assingnment.Utils.Utils.Companion.DomainName
import yang.com.assingnment.Utils.Utils.Companion.domainResponse

class SplashScreen() : AppCompatActivity(), mDomainResponse {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)

        if (Utils?.checkConnection(this)) {
            getDomainData()
        }
    }

    private fun getDomainData() {

        var getDomainData = RetrofitService().createRetrofit().domains()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe { response: DomainResponse? ->
                    if (response != null) {

                        Onsuccess(response)
                        Log.v("sandeep ", "sandeep " + response.toString())
                    } else {
                        OnFail("Please check internet Connection!")
                    }
                }

    }


    override fun Onsuccess(response: DomainResponse) {
        domainResponse = response


        DomainName?.add(domainResponse?.getData()?.getDomains()?.get(0)?.domain!!);
        DomainName?.add(domainResponse?.getData()?.getDomains()?.get(1)?.domain!!);
        DomainId?.add(domainResponse?.getData()?.getDomains()?.get(0)?.id!!);
        DomainId?.add(domainResponse?.getData()?.getDomains()?.get(1)?.id!!);

        startActivity(Intent(this, LoginActivity::class.java))
        finish()
    }

    override fun OnFail(error: kotlin.String) {

        Toast.makeText(this, error, Toast.LENGTH_LONG).show()
    }
}
