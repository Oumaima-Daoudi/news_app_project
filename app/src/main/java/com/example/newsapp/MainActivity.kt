package com.example.newsapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

import androidx.databinding.DataBindingUtil

import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.newsapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding : ActivityMainBinding=
            DataBindingUtil.setContentView(this, R.layout.activity_main)


        val allitems=binding.myrecycler
        val users = ArrayList<news>()
        users.add(news("Israël lance de nouvelles frappes sur Gaza, appels aux négociations sur les otages", "Israël a lancé de nouvelles frappes sur la bande de Gaza dimanche au moment où les dirigeants israéliens font face à une pression croissante pour négocier et obtenir la libération d'otages enlevés par le Hamas.\n" +
                "\n" +
                "Les proches des otages ont multiplié les appels au Premier ministre israélien Benjamin Netanyahu pour le pousser à conclure un accord sur la libération des captifs alors que l'armée a admis avoir tué 'par erreur' trois d'entre eux dans le territoire palestinien.\n" +
                "\n" +
                "Les trois otages tués faisaient partie des quelque 250 personnes capturées lors de l'attaque sans précédent lancée le 7 octobre par le Hamas sur le sol israélien qui a fait 1 140 morts, selon les dernières données fournies par les autorités israéliennes.\"", R.drawable.red))
        users.add(news("Bob", "helooo", R.drawable.hydrangea))
        users.add(news("Joes",  "hiiii", R.drawable.flower))
        users.add(news("Merry", "helooo", R.drawable.marriage))
        users.add(news("Alexandra", "Alexandra", R.drawable.rose))
        val layoutmanager = LinearLayoutManager(this)
        layoutmanager.orientation = LinearLayoutManager.VERTICAL
        allitems.layoutManager=layoutmanager
        val adapt=newsAdapter(users)
        allitems.adapter=adapt

    }
}