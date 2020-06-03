package com.example.taskmanager.database.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.taskmanager.database.entity.Task


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
    @Query("SELECT * FROM  task_table Where taskDayType = 1 order by taskDate ASC")
    fun getTodayTask(): LiveData<List<Task>>
    @Query("SELECT * FROM  task_table Where taskDayType = 2 order by taskDate ASC")
    fun getTomorrowTask(): LiveData<List<Task>>
    @Query("SELECT * FROM  task_table Where taskDayType = 3 order by taskDate ASC")
    fun getNextDayTask(): LiveData<List<Task>>

    @Query("SELECT * FROM  task_table Where taskDayType =:dayType")
    fun getAllTask1(dayType:Int): LiveData<List<Task>>

    @Query("DELETE FROM task_table")
    fun deleteAll()


    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insert(task: Task)


    @Delete
    fun delete(task: Task)

    @Update
    fun updateTask(vararg task: Task)
}