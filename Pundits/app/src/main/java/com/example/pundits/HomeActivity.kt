package com.example.pundits

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.cardview.widget.CardView
import okhttp3.OkHttpClient

class HomeActivity : AppCompatActivity() {

    val client = OkHttpClient()



//    api-football-v1.p.rapidapi.com

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        clickListener()
    }

    public fun clickListener(){

        var premierLeague = findViewById<CardView>(R.id.premierLeague)
        var laLiga = findViewById<CardView>(R.id.laLiga)
        var bundesliga = findViewById<CardView>(R.id.bundesliga)
        var serieA = findViewById<CardView>(R.id.serieA)
        var ligue1 = findViewById<CardView>(R.id.ligue1)
        var indianSuperLeague = findViewById<CardView>(R.id.indianSuperLeague)

        premierLeague.setOnClickListener { openPremierLeague() }
        laLiga.setOnClickListener { openLaliga() }
        bundesliga.setOnClickListener { openBundesliga() }
        serieA.setOnClickListener { openSerieA() }
        ligue1.setOnClickListener { openLigue1() }
        indianSuperLeague.setOnClickListener { openIndianSuperLeague() }

    }

    public fun openPremierLeague(){
        startActivity(Intent(this@HomeActivity, PremierLeague::class.java))
    }

    public fun openLaliga(){
        startActivity(Intent(this@HomeActivity, Laliga::class.java))
    }

    public fun openSerieA(){
        startActivity(Intent(this@HomeActivity, SerieA::class.java))
    }

    public fun openLigue1(){
        startActivity(Intent(this@HomeActivity, Ligue1::class.java))
    }

    public fun openBundesliga(){
        startActivity(Intent(this@HomeActivity, Bundesliga::class.java))
    }

    public fun openIndianSuperLeague(){
        startActivity(Intent(this@HomeActivity, IndianSuperLeague::class.java))
    }
}