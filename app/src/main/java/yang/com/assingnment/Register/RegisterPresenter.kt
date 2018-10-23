package yang.com.assingnment.Register

import android.R
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.util.Log
import android.widget.ArrayAdapter
import android.widget.Spinner
import com.google.gson.JsonObject
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.activity_login.*
import yang.com.assingnment.R.id.spinner1
import yang.com.assingnment.Register.Module.RegisterUserResponse
import yang.com.assingnment.Register.Module.SuccessResp
import yang.com.assingnment.Register.Module.User
import yang.com.assingnment.Register.RegisterActivity
import yang.com.assingnment.Service.RetrofitService
import yang.com.assingnment.Utils.Utils


/**
 * Created by yang on 22/02/18.
 */
class RegisterPresenter {

    private var activity: RegisterActivity

    private lateinit var subscribe: Disposable


    private var registerResponse: RegisterResponse

    constructor(activity: RegisterActivity, registerResponse: RegisterResponse) {
        this.activity = activity
        this.registerResponse = registerResponse
    }

     fun initspinner(spinner: Spinner) {
        val adapter = ArrayAdapter(activity, R.layout.simple_spinner_dropdown_item,
                Utils.DomainName)
        spinner.adapter = adapter


    }

    fun mRegisterAPI(user: User){

        var jobj = JsonObject()

        jobj.addProperty("domain",user.domainID)
        jobj.addProperty("email",user.email!!.toString())
        jobj.addProperty("name",user.name!!.toString())
        jobj.addProperty("password",user.password!!.toString())

        subscribe = RetrofitService().createRetrofit().getRegisterAccess(jobj)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
//                .doOnNext { t: RegisterUserResponse? -> Log.v("sandeep   ",t!!.toString()) }
                .subscribe ({ t: SuccessResp? ->
                    if (t != null) {
                        registerResponse.SuccessResponse(t)

                        /* if (t.success==true ) {
                             registerResponse.RegisterSuccessResponse(t)

                         }
                         if (t.fail==true){
                             registerResponse.ErrorResponse("Sandeep "+t.errors.toString())
                         }*/
                    }

                },
                        {t ->   registerResponse.ErrorResponse("Error is "+t.message!!.toString())}
                )
    }

    fun mDestroyAPI(){
        try {

            if (subscribe!=null){
                subscribe.dispose()
            }
        }catch (t:Exception){}

    }

}