package yang.com.assingnment.HomePage

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.util.Log
import android.view.View
import android.widget.Toast
import com.google.gson.JsonObject
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.holidays.*
import yang.com.assingnment.HomePage.Module.HolidaysResponse
import yang.com.assingnment.R
import yang.com.assingnment.Register.Module.SuccessResp
import yang.com.assingnment.Service.RetrofitService

/**
 * Created by yang on 23/10/18.
 */
class Holidays : AppCompatActivity(),RecyclerViewClickListener {
    override fun onClick(itemId: Int, type: String) {

        Toast.makeText(this,"clicked on Position $itemId",Toast.LENGTH_LONG).show()
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.holidays)
        UserTask()
    }

    fun homepage(view : View){
        startActivity(Intent(this,HomePage::class.java))

    }
    private fun UserTask() {
        var subscribe = RetrofitService().createRetrofit().getUserholidays()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe { response: HolidaysResponse? ->
                    if (response != null) {
                        Log.v("sandeep s","sandeep "+response.toString())
                        SetData(response)
                    }
                }
    }

    private fun SetData(response: HolidaysResponse) {



        val horizontalLayoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        recycleView.layoutManager = horizontalLayoutManager
        var adapter = TipsRecycleAdapter(this,response,"Yang",this)
        recycleView.adapter=adapter
    }
}