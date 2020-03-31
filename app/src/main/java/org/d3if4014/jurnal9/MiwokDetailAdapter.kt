package org.d3if4014.jurnal9

import android.graphics.Color
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.miwok_item.view.container_item
import kotlinx.android.synthetic.main.miwok_item_image.view.*
import org.d3if4014.jurnal9.network.WordListData

//private var glide: RequestManager? = null

class MiwokDetailAdapter(private val myDataset: List<WordListData>?) :
    RecyclerView.Adapter<MiwokDetailAdapter.MyViewHolder>() {

    class MyViewHolder(val view: View) : RecyclerView.ViewHolder(view)

    // Create new views (invoked by the layout manager)
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val people_item = LayoutInflater.from(parent.context)
            .inflate(R.layout.miwok_item_image, parent, false)
        return MyViewHolder(
            people_item
        )
    }

    // Replace the contents of a view (invoked by the layout manager)
    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.view.tv_1.text = myDataset?.get(position)?.defaultWord.toString()
        holder.view.tv_2.text = myDataset?.get(position)?.miwokWord.toString()
        holder.view.container_item.setBackgroundColor(Color.parseColor( DetailMiwok.bgSelected))

        Log.i("tesImg", "https://dif.indraazimi.com/miwok/${myDataset?.get(position)?.image}")
        if (myDataset?.get(position)?.image != null) {
            Glide.with(holder.view.context).load("https://dif.indraazimi.com/miwok/${myDataset?.get(position)?.image}").into(holder.view.iv_miwok)
        }else {
            Glide.with(holder.view.context).clear(holder.view.iv_miwok)
            // remove the placeholder (optional); read comments below
            holder.view.iv_miwok.setImageDrawable(null);
        }

    }

    override fun getItemCount(): Int {
        return 3
    }

}