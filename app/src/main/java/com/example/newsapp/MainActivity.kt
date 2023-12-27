package com.example.newsapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.newsapp.Models.NewsApiResponse
import com.example.newsapp.Models.NewsHeadlines
import com.example.newsapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    val listener: OnFetchDataListener<NewsApiResponse> = object : OnFetchDataListener<NewsApiResponse> {
        override fun OnFetchData(list: MutableList<NewsHeadlines>, message: String) {
            binding.showNews(list)
        }

        override fun OnError(message: String) {
            // Handle error if needed
        }
    }

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        val manager = RequestManager(this)
        manager.GetNewsHeadlines(listener, "general", null)

        // Other code related to onCreate if needed
    }

    private fun ActivityMainBinding.showNews(mylist: List<NewsHeadlines>) {
        myrecycler.setHasFixedSize(true)
        val mylayout = GridLayoutManager(this@MainActivity, 1)
        myrecycler.layoutManager = mylayout
        val myadapter = newsAdapter(mylist)
        myrecycler.adapter = myadapter
    }
}
