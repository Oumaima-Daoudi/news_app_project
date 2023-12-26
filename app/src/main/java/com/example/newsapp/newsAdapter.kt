package com.example.newsapp

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.newsapp.Models.NewsHeadlines


class newsAdapter(val data:List<NewsHeadlines>): RecyclerView.Adapter<newsAdapter.MyViewHolder>()

{



    class MyViewHolder(val row: View, private  val data: List<NewsHeadlines>) : RecyclerView.ViewHolder(row)
    {

        val image=row.findViewById<ImageView>(R.id.img)
        val textt=row.findViewById<TextView>(R.id.title)

        val txt_description  = row.findViewById<TextView>(R.id.description)
        val cardd=row.findViewById<CardView>(R.id.cardView)
        
        init {
            cardd.setOnClickListener{
                val intent= Intent(row.context , DetailsPageActivity::class.java)
                intent.putExtra("descrpt", data[adapterPosition].description)
                intent.putExtra("imageRe",  data[adapterPosition].urlToImage)
                intent.putExtra("title", data[adapterPosition].title)
                row.context.startActivity(intent)
            }
        }
    }



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val layout=
            LayoutInflater.from(parent.context).inflate(R.layout.item, parent, false)
        return MyViewHolder(layout, data)
    }
    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val item=data[position]
        holder.textt.text=item.title
        holder.txt_description.text=item.source.toString()
        //holder.image.setImageResource(item.image)
        if (item.urlToImage != null){
            Glide.with(holder.image)
                .load(item.urlToImage)
                .into(holder.image)
        }

    }

    override fun getItemCount(): Int = data.size
}

//private fun ImageView.setImageResource(image: String?) {

//}




