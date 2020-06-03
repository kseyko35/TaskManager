package com.example.taskmanager.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.example.taskmanager.database.AppDatabase
import com.example.taskmanager.database.entity.Task
import com.example.taskmanager.repository.TaskRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch


/**     Code with ❤
╔════════════════════════════╗
║   Created by Seyfi ERCAN   ║
╠════════════════════════════╣
║  seyfiercan35@hotmail.com  ║
╠════════════════════════════╣
║         31,May,2020        ║
╚════════════════════════════╝
 */

class TaskViewModel (application: Application) : AndroidViewModel(application){
    private val repository: TaskRepository

    val todayTask: LiveData<List<Task>>
    val tomorrowTask: LiveData<List<Task>>
    val nextDayTask: LiveData<List<Task>>

    init {
        val taskDao = AppDatabase.getDatabase(application).taskDao()
        repository= TaskRepository(taskDao)
        todayTask=  repository.todayTask
        tomorrowTask=  repository.tomorrowTask
        nextDayTask=repository.nextDayTask

    }
    fun insert(task:Task) = viewModelScope.launch(Dispatchers.IO){
        repository.insert(task)
    }
    fun delete(task: Task) {
        repository.delete(task)
    }

}