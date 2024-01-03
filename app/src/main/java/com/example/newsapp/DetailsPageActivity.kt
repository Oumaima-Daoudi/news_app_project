package com.example.newsapp

import android.content.res.ColorStateList
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.core.content.ContextCompat
import androidx.databinding.DataBindingUtil
import com.bumptech.glide.Glide
import com.example.newsapp.Models.NewsHeadlines
import com.example.newsapp.databinding.ActivityDetailsPageBinding

class DetailsPageActivity : AppCompatActivity() {
    val headlines : NewsHeadlines?= null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding:ActivityDetailsPageBinding =
            DataBindingUtil.setContentView(this, R.layout.activity_details_page)


        val totalRatingTextView=binding.totalRatingTextView
        var newRating : Double
        val ratingBar=binding.ratingBar
        val evaluateButton=binding.evaluateButton
        var totalRating=0.0
        var usercount=0
        val fieldImae=binding.imageView
        val title=binding.textView2
       val sourceof=binding.textView3
        val descrt=binding.textView4
        val callintent=intent
        title.text=callintent.getStringExtra("title")
        sourceof.text=callintent.getStringExtra("sourceof")
        descrt.text=callintent.getStringExtra("descrpt")
        val imageurl=intent.getStringExtra("imageRe")
        //fieldImae.setImageResource(callintent.getIntExtra("imageRe", R.drawable.img))
        Glide.with(this).load(imageurl).into(fieldImae)
        fun showToast(message: String) {
            Toast.makeText(this, message, Toast.LENGTH_SHORT).show()

        }

        fun updateRatingBarColor(color: Int) {
            val colorStateList = ColorStateList.valueOf(color)
            ratingBar.progressTintList = colorStateList
        }

        evaluateButton.setOnClickListener{
            val rating=ratingBar.rating
            if(rating> 0){

                totalRating+=rating
                usercount++

                totalRatingTextView.text = "Total Ratings: $usercount"
                val averageRating=totalRating/rating

                when{
                    usercount>=5 -> {
                        showToast("Great rating! Thank you!")
                        updateRatingBarColor(Color.YELLOW)
                        evaluateButton.isEnabled = true
                    }
                    averageRating >= 4.0 -> {
                        showToast("Average rating. We appreciate your feedback.")
                        updateRatingBarColor(Color.GREEN)
                    }
                    else -> {
                        showToast("Poor rating. We'll work to improve.")
                        updateRatingBarColor(Color.RED)
                    }
                }
            }
            else {
                showToast("Please provide a rating before evaluating.")
            }
        }



    }
}