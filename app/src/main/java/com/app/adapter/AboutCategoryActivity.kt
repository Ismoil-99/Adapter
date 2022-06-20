package com.app.adapter

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import android.widget.TextView
import com.app.adapter.databinding.ActivityAboutCategoryBinding
import com.app.adapter.databinding.ActivityMainBinding


class AboutCategoryActivity : AppCompatActivity() {
    private var name: TextView? = null
    private var description:TextView? = null
    private var price : TextView? = null
    lateinit var backButton:ImageButton
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_about_category)
        var intent = intent
        name = findViewById(R.id.name)
        description = findViewById(R.id.description)
        price = findViewById(R.id.price)
        backButton = findViewById(R.id.back_button)
        name?.text = intent.getStringExtra("NAME")
        description?.text = intent.getStringExtra("DESCRIPTION")
        price?.text = "В КОРЗИНУ ЗА ${intent.getStringExtra("PRICE")} TJS"
        //pizzaImage.setImageResource(intent.getStringExtra("IMAGE")!!    .toInt())
        backButton.setOnClickListener {finish()}
}
}