package com.example.todoapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ListView
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider

class MainActivity : AppCompatActivity() {
    private lateinit var taskViewModel: TaskViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val adapter = TaskAdapter(this)
        val listView: ListView = findViewById(R.id.taskListView)
        listView.adapter = adapter

        taskViewModel = ViewModelProvider(this).get(TaskViewModel::class.java)

        taskViewModel.allTasks.observe(this, Observer { tasks ->
            tasks?.let { adapter.setTasks(it) }
        })

        val taskEditText: EditText = findViewById(R.id.taskEditText)
        val addTaskButton: Button = findViewById(R.id.addTaskButton)

        addTaskButton.setOnClickListener {
            val taskDescription = taskEditText.text.toString()
            if (taskDescription.isNotEmpty()) {
                val task = Task(0, taskDescription) // Set a temporary ID
                taskViewModel.insert(task)
                taskEditText.text.clear()
            }
        }

        listView.setOnItemClickListener { _, _, position, _ ->
            val task = adapter.getItem(position) as Task
            taskViewModel.delete(task)
        }
    }
}
