package com.example.appforfans.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.appforfans.R
import com.example.appforfans.model.SampleData

class ItemAdapter (
    private val mContext: Context,
    val itemsList: ArrayList<SampleData>) : RecyclerView.Adapter<ItemAdapter.VieHolder>() {
    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): VieHolder {
        val v = LayoutInflater.from(p0.context).inflate(R.layout.product_item, p0, false)
        return VieHolder(v)
    }

    override fun getItemCount(): Int {
        return itemsList.size
    }

    override fun onBindViewHolder(holder: VieHolder, p1: Int) {
        //Bind data to recyclervView
        val product: SampleData = itemsList[p1]
        holder.name.text = product.name
        holder.pic.setImageResource(product.pic)

        holder.pic.setOnClickListener {
            // do nothing
        }

    }

    class VieHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val name = itemView.findViewById(R.id.txt_product) as TextView
        val pic = itemView.findViewById(R.id.img_product) as ImageView
    }
}
