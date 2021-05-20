package com.example.appforfans

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.LinearLayout
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.appforfans.adapter.CustomAdapter
import com.example.appforfans.model.DataSets
import com.example.appforfans.model.SampleData
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    @SuppressLint("WrongConstant")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView.layoutManager = LinearLayoutManager(this, LinearLayout.VERTICAL, false)

        // ############ DATA SETS
        val categories = DataSets().getCategoriesData()

        val adapter = CustomAdapter(this, categories)

        recyclerView.adapter = adapter

    }
}