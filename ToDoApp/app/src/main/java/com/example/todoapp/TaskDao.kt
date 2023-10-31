package com.example.todoapp

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query

@Dao
interface TaskDao {
    @Insert
    suspend fun insertTask(task: Task)

    @Query("SELECT * FROM Task")
    fun getAllTasks(): LiveData<List<Task>>

    @Delete
    suspend fun deleteTask(task: Task)
}
