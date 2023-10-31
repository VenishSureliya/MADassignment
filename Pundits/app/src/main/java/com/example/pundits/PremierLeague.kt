package com.example.pundits

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import okhttp3.Call
import okhttp3.Callback
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.Response
import java.io.IOException

class PremierLeague : AppCompatActivity() {

    val client = OkHttpClient()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_premier_league)



        val request = Request.Builder()
            .url("https://api-football-v1.p.rapidapi.com/v3/standings?season=2020&league=39")
            .get()
            .addHeader("X-RapidAPI-Key", "d890374de8msh810665a61dd18b5p13b4a0jsn3dd008f4aeb6")
            .addHeader("X-RapidAPI-Host", "api-football-v1.p.rapidapi.com")
            .build()


        val response = client.newCall(request).enqueue(object : Callback {
            override fun onFailure(call: Call, e: IOException) {

            }

            override fun onResponse(call: Call, response: Response) {
                if (response.isSuccessful){
                    val responseBody = response.body?.string()
                }
                else{

                }
            }
        })




    }
}