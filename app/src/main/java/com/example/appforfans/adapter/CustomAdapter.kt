package com.example.appforfans.adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.appforfans.ItemActivity
import com.example.appforfans.R
import com.example.appforfans.model.SampleData

class CustomAdapter (
    private val mContext: Context,
    val categoryList: ArrayList<SampleData>) : RecyclerView.Adapter<CustomAdapter.VieHolder>() {
    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): VieHolder {
        val v = LayoutInflater.from(p0.context).inflate(R.layout.category_item, p0, false)
        return VieHolder(v)
    }

    override fun getItemCount(): Int {
        return categoryList.size
    }

    override fun onBindViewHolder(holder: VieHolder, p1: Int) {
        //Bind data to recyclervView
        val user: SampleData = categoryList[p1]
        holder.name.text = user.name
        holder.pic.setImageResource(user.pic)

        holder.pic.setOnClickListener {
            val productIntent = Intent(mContext, ItemActivity::class.java)
            productIntent.putExtra("Category", user.name)
            mContext.startActivity(productIntent)
        }

    }

    class VieHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val name = itemView.findViewById(R.id.categoryTxt) as TextView
        val pic = itemView.findViewById(R.id.sampleImg) as ImageView
    }
}
