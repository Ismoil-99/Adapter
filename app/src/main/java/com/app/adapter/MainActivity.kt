package com.app.adapter

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.app.adapter.data.*
import com.app.adapter.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private var recyclerView  : RecyclerView? = null
    private lateinit var adapter: ListAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val pizaList = pizzaList()
        val beveragesList = beveragesList()
        val desertsList = desertsList()
        val snackList = snackList()
        val comboList = comboList()
        when(0){
            0 -> seputAdapter(pizaList)
            1 -> seputAdapter(beveragesList)
            2 -> seputAdapter(desertsList)
            3 -> seputAdapter(snackList)
            4 -> seputAdapter(comboList)
        }
    }
    private fun seputAdapter(piza:List<Food>) {
        recyclerView = findViewById(R.id.adapter)
        recyclerView?.layoutManager = LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false)
        adapter = ListAdapter()
        adapter.submitList(piza)
        adapter.onItemClick = { food ->
            val intent = Intent(this, AboutCategoryActivity::class.java)
            intent.putExtra("NAME", food.name)
            intent.putExtra("DESCRIPTION", food.description)
            intent.putExtra("PRICE", food.price.toString())
            intent.putExtra("IMAGE",food.imageId )
            startActivity(intent)
        }
        recyclerView?.adapter = adapter
    }
}