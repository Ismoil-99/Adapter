package com.app.adapter

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.HorizontalScrollView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.app.adapter.data.ListShowPizza
import com.app.adapter.data.PizzaModel
import com.app.adapter.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private var recyclerView  : RecyclerView? = null
    private val words:List<String> = listOf("A","Б","В","Г","Д","Е","Ж","З","И","К","Л","М","Н","О","П","Р","С","Т")
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        val pizaList = ListShowPizza().listPizza()
        seputAdapter(pizaList)
    }
    private fun seputAdapter(piza:List<PizzaModel>) {
        recyclerView = binding.adapter
        recyclerView?.layoutManager = LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false)
        recyclerView?.adapter = ListAdapter(piza)
    }
}