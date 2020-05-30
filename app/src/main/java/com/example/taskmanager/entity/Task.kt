package com.example.taskmanager.entity

import androidx.room.Entity
import androidx.room.PrimaryKey


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
class Task(

    var taskName: String,
    var taskDescription: String
) {
    @PrimaryKey(autoGenerate = true)
    var taskId: Int = 0
}


