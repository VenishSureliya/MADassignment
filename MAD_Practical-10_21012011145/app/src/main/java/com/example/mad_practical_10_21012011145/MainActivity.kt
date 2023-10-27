package com.example.mad_practical_10_21012011145

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ListView
import com.google.android.material.floatingactionbutton.FloatingActionButton
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import org.json.JSONArray
import org.json.JSONException
import org.json.JSONObject

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val floatingButton = findViewById<FloatingActionButton>(R.id.floating_Button)

        floatingButton.setOnClickListener {
            sendDataToListView()
            //Intent(this@MainActivity, MapsActivity::class.java).apply { startActivity(this) }
        }

    }


    private fun getPersonDetailsFromJson(sJson: String?) {
        val personList = ArrayList<Contact>()
        try {
            val jsonArray = JSONArray(sJson)
            for (i in 0 until jsonArray.length()) {
                val jsonObject = jsonArray[i] as JSONObject
                val person = Contact(jsonObject)
                personList.add(person)
            }
            val personListView = findViewById<ListView>(R.id.listView)
            personListView.adapter = ContactAdapter(this, personList)
        } catch (ee: JSONException) {
            ee.printStackTrace()
        }
    }

    fun sendDataToListView() {

        /*val personListView = findViewById<ListView>(R.id.listView)
        val personList = arrayListOf<Contact>(Contact("01", "Venish", "venishsureliya@gmail.com", "97232 15199", "Junagadh, Gujarat", 101.230, 450.5645),
            Contact("02", "Prashant", "prashantrathod@gmail.com", "99812 84151", "Ahmedabad, Gujarat", 4546.5267, 482353.7),
            Contact("01", "Rohan", "rohan@gmail.com", "97554 48199", "Deesa, Gujarat", 1046.2480, 4545.645),
            Contact("02", "Yuvraj", "yuvi@gmail.com", "99812 84151", "Ahmedabad, Gujarat", 4546.5267, 41153.7))

        personListView.adapter = ContactAdapter(this, personList)*/

        CoroutineScope(Dispatchers.IO).launch {
            try {
                val data = HttpRequest().makeServiceCall(
                    "https://api.json-generator.com/templates/qjeKFdjkXCdK/data",
                    "rbn0rerl1k0d3mcwgw7dva2xuwk780z1hxvyvrb1"
                )
                withContext(Dispatchers.Main) {
                    try {
                        if (data != null)
                            runOnUiThread { getPersonDetailsFromJson(data) }
                    } catch (e: Exception) {
                        e.printStackTrace()
                    }
                }
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }

    }

}