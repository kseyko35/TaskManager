package com.example.taskmanager.dao

import androidx.room.*
import com.example.taskmanager.entity.Task


/**     Code with ❤
╔════════════════════════════╗
║   Created by Seyfi ERCAN   ║
╠════════════════════════════╣
║  seyfiercan35@hotmail.com  ║
╠════════════════════════════╣
║      29,May,2020      ║
╚════════════════════════════╝
 */
@Dao
interface TaskDao {
    @Query("SELECT * FROM  task_table")
    fun getAllTask(): List<Task>

//    @Query("SELECT * FROM task_table WHERE taskName LIKE :title")
//    fun findByTitle(title: String): Task

    @Insert
    fun insertAll(vararg task: Task)

    @Delete
    fun delete(task: Task)

    @Update
    fun updateTask(vararg task: Task)
}