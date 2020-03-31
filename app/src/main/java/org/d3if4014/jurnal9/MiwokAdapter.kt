package org.d3if4014.jurnal9

import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.miwok_item.view.*
import org.d3if4014.jurnal9.network.MiwokData


class MiwokAdapter(private val myDataset: List<MiwokData>) :
    RecyclerView.Adapter<MiwokAdapter.MyViewHolder>() {

    class MyViewHolder(val view: View) : RecyclerView.ViewHolder(view)

    // Create new views (invoked by the layout manager)
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val people_item = LayoutInflater.from(parent.context)
            .inflate(R.layout.miwok_item, parent, false)
        return MyViewHolder(
            people_item
        )
    }

    // Replace the contents of a view (invoked by the layout manager)
    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.view.tv_category.text = myDataset[position].category.toString()
        val bg = myDataset[position].background.toString()
        holder.view.container_item.setBackgroundColor(Color.parseColor( myDataset[position].background.toString()))

        holder.view.setOnClickListener {
//            var bundle = bundleOf("content" to myDataset[position].wordList)
//            val extras = Bundle()
//            extras.putSerializable("wl", myDataset[position].wl)
            DetailMiwok.selectedMiwok = myDataset[position].wordList
            DetailMiwok.bgSelected = myDataset[position].background.toString()
            holder.view.findNavController().navigate(R.id.action_miwokFragment_to_detailFragment)
        }
    }

    // Return the size of your dataset (invoked by the layout manager)
    override fun getItemCount() = myDataset.size
}