package yang.com.assingnment.HomePage

import android.content.Intent
import android.graphics.PointF
import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity
import android.widget.Toast
import com.dlazaro66.qrcodereaderview.QRCodeReaderView
import com.google.gson.JsonObject
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import yang.com.assingnment.R

import kotlinx.android.synthetic.main.activity_home_page.*
import kotlinx.android.synthetic.main.content_home_page.*
import yang.com.assingnment.Register.Module.SuccessResp
import yang.com.assingnment.Service.RetrofitService

class HomePage : AppCompatActivity(), QRCodeReaderView.OnQRCodeReadListener {



    override fun onQRCodeRead(text: String?, points: Array<out PointF>?) {

        if (text != null) {
            getAttendance(text)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home_page)
        setSupportActionBar(toolbar)

        fab.setOnClickListener { view ->
            Snackbar.make(view, "Please allow camera permission manually", Snackbar.LENGTH_LONG)
                    .setAction("Action", null).show()
        }

        qrdecoderview.setOnQRCodeReadListener(this)
        qrdecoderview.setQRDecodingEnabled(true);
        qrdecoderview.setAutofocusInterval(2000L)
        qrdecoderview.setTorchEnabled(true)
        qrdecoderview.setFrontCamera()
        qrdecoderview.setBackCamera()

    }

    private fun getAttendance(key :String) {

        var jobj = JsonObject()

        jobj.addProperty("latitude", "72.67400")
        jobj.addProperty("longitude","23.02587")
        jobj.addProperty("key", key)
        //domain
        var subscribe = RetrofitService().createRetrofit().getUserAttendance(jobj)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe { response: SuccessResp? ->
                    if (response?.success ==true) {
                        text.text = response?.msg
                        Toast.makeText(this, "Your attendance Marked.",Toast.LENGTH_LONG).show()
                        startActivity(Intent(this,Holidays::class.java))

                    }
                }
    }


    override fun onResume() {
        super.onResume()
        qrdecoderview.startCamera()
    }

    override fun onPause() {
        super.onPause()
        qrdecoderview.stopCamera()
    }
}
