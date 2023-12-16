package com.example.newsapp

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.TextView

class newsAdapter(var appcontext: Context, var layout: Int, var news: ArrayList<news>): ArrayAdapter<news>(appcontext,layout,news){

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val view : View = LayoutInflater.from(appcontext).inflate(layout,null)
        val p = news.get(position)
        val img = view.findViewById<ImageView>(R.id.img)
        val txt_title = view.findViewById<TextView>(R.id.title)
        val txt_description = view.findViewById<TextView>(R.id.description)
        p.img?.let { img.setImageResource(it) }
        txt_title.text = p.title
        txt_description.text = p.description
        return view
    }

}
