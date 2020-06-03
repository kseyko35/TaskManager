package com.example.taskmanager.repository

import androidx.annotation.WorkerThread
import androidx.lifecycle.LiveData
import com.example.taskmanager.database.dao.TaskDao
import com.example.taskmanager.database.entity.Task


/**     Code with ❤
╔════════════════════════════╗
║   Created by Seyfi ERCAN   ║
╠════════════════════════════╣
║  seyfiercan35@hotmail.com  ║
╠════════════════════════════╣
║        31,May,2020         ║
╚════════════════════════════╝
 */
class TaskRepository(private val taskDao: TaskDao){

    val todayTask: LiveData<List<Task>> = taskDao.getTodayTask()
    val tomorrowTask: LiveData<List<Task>> = taskDao.getTomorrowTask()
    val nextDayTask: LiveData<List<Task>> = taskDao.getNextDayTask()
    @Suppress("RedundantSuspendModifier")
    @WorkerThread
    suspend fun insert(task: Task) {
        taskDao.insert(task)
    }
    fun delete(task: Task){
        taskDao.delete(task)
    }



}