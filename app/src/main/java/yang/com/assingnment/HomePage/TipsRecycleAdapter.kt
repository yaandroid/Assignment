package yang.com.assingnment.HomePage

import android.app.Activity
import android.support.v7.widget.RecyclerView
import android.text.Html
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.RelativeLayout
import android.widget.TextView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import yang.com.assingnment.HomePage.Module.HolidaysResponse
import yang.com.assingnment.R


/**
 * Created by yang on 27.
 */
class TipsRecycleAdapter : RecyclerView.Adapter<TipsRecycleAdapter.ViewHolder> {
    private lateinit var activity: Holidays
    private lateinit var homeDetails: HolidaysResponse
    private lateinit var type: String

    private lateinit var recyclerViewClickListener: RecyclerViewClickListener

    constructor(activity: Holidays, homeDetails: HolidaysResponse, type: String, recyclerViewClickListener: RecyclerViewClickListener) {
        this.activity = activity
        this.homeDetails = homeDetails
        this.type = type
        this.recyclerViewClickListener=recyclerViewClickListener
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TipsRecycleAdapter.ViewHolder {

        val itemLayoutView = LayoutInflater.from(parent.context).inflate(R.layout.custom_advice_module, parent,false)
//        val displaymetrics = DisplayMetrics()
//        activity.windowManager.defaultDisplay.getMetrics(displaymetrics)
//        //if you need three fix imageview in width
//        val devicewidth = (displaymetrics.widthPixels -30)
//
//        //if you need 4-5-6 anything fix imageview in height
//        val deviceheight = displaymetrics.heightPixels
//
//        itemLayoutView.layoutParams = RecyclerView.LayoutParams(devicewidth, deviceheight)
        return ViewHolder(itemLayoutView)

    }

    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {

                viewHolder.nametxt?.tag = homeDetails?.data?.holidays?.get(position)?.date
                viewHolder.nametxt!!.text = homeDetails?.data?.holidays?.get(position)?.title
                viewHolder.description!!.text = Html.fromHtml(homeDetails?.data?.holidays?.get(position)?.description)
                viewHolder.cardview_datetxt!!.text = homeDetails?.data?.holidays?.get(position)?.date
                loadFullImage(activity, viewHolder.image_tips!!, homeDetails?.data?.holidays?.get(position)?.image!!)

        viewHolder.card_layouts?.tag = position
        viewHolder.card_layouts?.setOnClickListener({
            recyclerViewClickListener.onClick(viewHolder.nametxt?.tag as Int,type)

        })

    }

    class ViewHolder(itemLayoutView: View) : RecyclerView.ViewHolder(itemLayoutView) {

        internal var nametxt: TextView? = null

        internal var description: TextView? = null
        internal var cardview_datetxt: TextView? = null
        internal var image_tips: ImageView? = null
        internal var card_layouts : RelativeLayout? = null
        init {
            nametxt = itemLayoutView.findViewById(R.id.cardview_nametxt)
            description = itemLayoutView.findViewById(R.id.description)
            cardview_datetxt = itemLayoutView.findViewById(R.id.cardview_datetxt)
            image_tips = itemLayoutView.findViewById(R.id.image_tips)
//             card_layouts = itemLayoutView.findViewById<RelativeLayout>(R.id.card_layout)

        }


    }
    override fun getItemCount(): Int {
        return homeDetails?.data?.holidays!!.size
    }

    fun loadFullImage(activity: Activity, imageView: ImageView, image_url: String) {
        Log.v("tips adapter  "," IMage url "+ image_url)
        val options = RequestOptions()
                .centerCrop()
                .placeholder(R.mipmap.ic_launcher_round)
                .error(R.mipmap.ic_launcher_round)
                .circleCrop()
        Glide.with(activity).load(image_url).apply(options).into(imageView)

    }


}
