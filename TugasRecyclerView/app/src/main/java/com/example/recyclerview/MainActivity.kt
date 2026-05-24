package com.example.recyclerview

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        val recyclerView: RecyclerView = findViewById(R.id.recyclerView)

        val dataList = listOf(
            ListItem(1, getString(R.string.title_item_1), getString(R.string.desc_item_1)),
            ListItem(2, getString(R.string.title_item_2), getString(R.string.desc_item_2)),
            ListItem(3, getString(R.string.title_item_3), getString(R.string.desc_item_3)),
            ListItem(4, getString(R.string.title_item_4), getString(R.string.desc_item_4)),
            ListItem(5, getString(R.string.title_item_5), getString(R.string.desc_item_5))
        )

        val adapter = ListAdapter(dataList)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = adapter
    }
}