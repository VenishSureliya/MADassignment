package com.example.mad_practical_10_21012011145

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.TextView

class ContactAdapter (context: Context, var arrayList: ArrayList<Contact>):ArrayAdapter<Contact>(context, 0, arrayList) {

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {

        val view = LayoutInflater.from(parent.context).inflate(R.layout.list_item_card, parent, false)

        view.findViewById<TextView>(R.id.name).text = arrayList.get(position).name
        view.findViewById<TextView>(R.id.cNumber).text = arrayList.get(position).phoneNum
        view.findViewById<TextView>(R.id.email).text = arrayList.get(position).emailID
        view.findViewById<TextView>(R.id.location).text = arrayList.get(position).address

        return view
    }

}