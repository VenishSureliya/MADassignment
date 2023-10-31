package com.example.todoapp

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.TextView

class TaskAdapter(context: Context) : ArrayAdapter<Task>(context, 0) {
    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val task = getItem(position)
        val view = convertView ?: LayoutInflater.from(context).inflate(
            R.layout.task_item,
            parent,
            false
        )

        val taskTextView: TextView = view.findViewById(R.id.taskTextView)
        taskTextView.text = task?.description

        return view
    }
}
