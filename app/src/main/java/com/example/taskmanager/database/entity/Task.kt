package com.example.taskmanager.database.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverters
import com.example.taskmanager.database.converter.DateConverter
import java.util.*


/**     Code with ❤
╔════════════════════════════╗
║   Created by Seyfi ERCAN   ║
╠════════════════════════════╣
║  seyfiercan35@hotmail.com  ║
╠════════════════════════════╣
║           29,May,2020      ║
╚════════════════════════════╝
 */

@Entity(tableName = "task_table")
@TypeConverters(DateConverter::class)
data class Task(

    var taskName: String,
    var taskDescription: String,
    var taskDate: Date? = null,
    var taskDayType: Int
) {
    @PrimaryKey(autoGenerate = true)
    var taskId: Int = 0
}


