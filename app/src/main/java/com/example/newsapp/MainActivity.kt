package com.example.newsapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ListView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val users = arrayListOf<news>()
        val news1 = news()
        news1.title = "Alice"
        news1.description = "helooo"
        news1.img = R.drawable.red
        users.add(news1)

        val news2 = news()
        news2.title = "Bob"
        news2.description = "helooo"
        news2.img = R.drawable.hydrangea
        users.add(news2)

        val news3 = news()
        news3.title = "Joes"
        news3.description = "hiiii"
        news3.img = R.drawable.flower
        users.add(news3)

        val news4 = news()
        news4.title = "Merry"
        news4.description = "helooo"
        news4.img = R.drawable.marriage
        users.add(news4)

        val news5 = news()
        news5.title = "Alexandra"
        news5.description = "Alexandra"
        news5.img = R.drawable.rose
        users.add(news5)

        val news6 = news()
        news6.title = "Mosh"
        news6.description = "Mosh"
        news6.img = R.drawable.tree
        users.add(news6)


        val adapter = newsAdapter(this,R.layout.item,users)
        val mListView = findViewById <ListView>(R.id.list)
        mListView.adapter = adapter
    }
}