package com.example.newsapp

import android.app.ProgressDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.newsapp.Models.NewsApiResponse
import com.example.newsapp.Models.NewsHeadlines
import com.example.newsapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() , View.OnClickListener{

    val listener: OnFetchDataListener<NewsApiResponse> = object : OnFetchDataListener<NewsApiResponse> {
        override fun OnFetchData(list: MutableList<NewsHeadlines>, message: String) {
            binding.showNews(list)
            dialog?.dismiss()

        }

        override fun OnError(message: String) {
            // Handle error if needed
        }
    }

    private lateinit var binding: ActivityMainBinding
    var dialog: ProgressDialog?= null
    var b1: Button?= null
    var b2: Button?= null
    var b3: Button?= null
    var b4: Button?= null
    var b5: Button?= null
    var b6: Button?= null
    var b7: Button?= null



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        val manager = RequestManager(this)
        manager.GetNewsHeadlines(listener, "general", null)
        dialog = ProgressDialog(this)
        dialog?.setTitle("Fetching news articles...")
        dialog?.show()

        b1 = binding.btnBusiness
        b1?.setOnClickListener(this)
        b2 = binding.btnEntertainment
        b2?.setOnClickListener(this)
        b3 = binding.btnGeneral
        b3?.setOnClickListener(this)
        b4 = binding.btnHealth
        b4?.setOnClickListener(this)
        b5 = binding.btnScience
        b5?.setOnClickListener(this)
        b6 = binding.btnSports
        b6?.setOnClickListener(this)
        b7 = binding.btnTechnology
        b7?.setOnClickListener(this)


        // Other code related to onCreate if needed
    }

    private fun ActivityMainBinding.showNews(mylist: List<NewsHeadlines>) {
        myrecycler.setHasFixedSize(true)
        val mylayout = GridLayoutManager(this@MainActivity, 1)
        myrecycler.layoutManager = mylayout
        val myadapter = newsAdapter(mylist)
        myrecycler.adapter = myadapter

    }

    override fun onClick(v: View?) {
        val button: Button = v as Button
        val category: String = button.text.toString()
        dialog?.setTitle("Fetching news articles of "+ category)
        dialog?.show()
        val manager = RequestManager(this)
        manager.GetNewsHeadlines(listener, category, null)

    }
}
