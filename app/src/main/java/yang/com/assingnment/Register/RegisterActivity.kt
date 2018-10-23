package yang.com.assingnment.Register

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.AdapterView
import android.widget.Toast
import com.google.gson.JsonObject
import kotlinx.android.synthetic.main.activity_login.*
import kotlinx.android.synthetic.main.activity_sign__up.*
import yang.com.assingnment.HomePage.Holidays
import yang.com.assingnment.HomePage.HomePage
import yang.com.assingnment.R
import yang.com.assingnment.Register.Module.RegisterUserResponse
import yang.com.assingnment.Register.Module.SuccessResp
import yang.com.assingnment.Register.Module.User
import yang.com.assingnment.Utils.Utils


/**
 * Created by yang on 22/02/18.
 */
class RegisterActivity : AppCompatActivity(),
        RegisterResponse, View.OnClickListener , AdapterView.OnItemSelectedListener{

    private var DomainPos: Int = 0


    private lateinit var registerPresenter: RegisterPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign__up)
        spinner.onItemSelectedListener=this

        registerPresenter = RegisterPresenter(this, this)

        registerPresenter.initspinner(spinner)

        singup_btn.setOnClickListener(this)
    }

    override fun onClick(p0: View?) {

        if (p0 == singup_btn) {

            getUserDetails()

        }
    }

    private fun getUserDetails() {
        var name = Signup_nametxt.text.toString()
        var email = Signup_email.text.toString()
        var password = Signup_password.text.toString()

        var user = User()
        user.domainID = DomainPos
        user.name = name
        user.email = email
        user.password = password
        registerPresenter.mRegisterAPI(user)

    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

    }



    override fun ErrorResponse(error: String) {
        Toast.makeText(this, "error $error", Toast.LENGTH_LONG).show()
    }

    override fun SuccessResponse(result: SuccessResp) {

        Toast.makeText(this, result.msg, Toast.LENGTH_LONG).show()
        Utils.RC_SIGN_IN = result.data?.token!!
        if (result.success==true)
        startActivity(Intent(this, Holidays::class.java))
    }

    override fun onDestroy() {
        super.onDestroy()
        registerPresenter.mDestroyAPI()

    }


    override fun onBackPressed() {
            super.onBackPressed()
    }


    override fun onNothingSelected(parent: AdapterView<*>?) {
    }

    override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
        DomainPos= Utils.DomainId?.get(position)

    }

}

