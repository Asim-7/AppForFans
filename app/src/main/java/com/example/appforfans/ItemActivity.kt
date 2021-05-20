package com.example.appforfans

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.MenuItem
import android.widget.LinearLayout
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.appforfans.adapter.CustomAdapter
import com.example.appforfans.adapter.ItemAdapter
import com.example.appforfans.model.DataSets
import com.example.appforfans.model.SampleData
import kotlinx.android.synthetic.main.activity_item.*

class ItemActivity : AppCompatActivity() {

    private var categoryName = ""

    @SuppressLint("WrongConstant")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_item)

        categoryName = intent.getStringExtra("Category").toString()

        val itemData = when(categoryName) {
            "MERCEDES" -> DataSets().getMercedesItems()
            "RED BULL" -> DataSets().getRedBullItems()
            "MCLAREN" -> DataSets().getMclarenItems()
            "FERRARI" -> DataSets().getFerrariItems()
            else -> DataSets().getMotorSportItems()
        }

        supportActionBar!!.setDisplayHomeAsUpEnabled(true)
        supportActionBar!!.title = "Shop Items"

        recyclerViewItems.layoutManager = LinearLayoutManager(this, LinearLayout.VERTICAL, false)

        val adapter = ItemAdapter(this, itemData)
        recyclerViewItems.adapter = adapter

    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        onBackPressed()
        finish()
        return super.onOptionsItemSelected(item)
    }
}