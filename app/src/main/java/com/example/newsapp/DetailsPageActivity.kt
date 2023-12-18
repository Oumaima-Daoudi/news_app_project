package com.example.newsapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.example.newsapp.databinding.ActivityDetailsPageBinding

class DetailsPageActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding:ActivityDetailsPageBinding =
            DataBindingUtil.setContentView(this, R.layout.activity_details_page)

        val fieldImae=binding.imageView
        val title=binding.textView2
       // val inff=binding.textView3
        val descrt=binding.textView4
        val callintent=intent
        title.text=callintent.getStringExtra("title")
        //inff.text=callintent.getStringExtra("inff")
        descrt.text=callintent.getStringExtra("descrpt")
        fieldImae.setImageResource(callintent.getIntExtra("imageRe", R.drawable.img))
    }
}