package com.example.madassignment

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class TaskAdapter(private val tasks: List<Task>) : RecyclerView.Adapter<TaskAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.task_item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val task = tasks[position]
        holder.taskTextView.text = task.description
        holder.taskCheckBox.isChecked = task.isCompleted
    }

    override fun getItemCount(): Int {
        return tasks.size
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val taskCheckBox: CheckBox = itemView.findViewById(R.id.taskCheckBox)
        val taskTextView: TextView = itemView.findViewById(R.id.taskTextView)
    }
}
