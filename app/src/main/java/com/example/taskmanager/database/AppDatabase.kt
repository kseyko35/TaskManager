package com.example.taskmanager.database

import android.content.Context
import androidx.room.Database
import androidx.room.Entity
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.taskmanager.dao.TaskDao
import com.example.taskmanager.entity.Task


/**     Code with ❤
╔════════════════════════════╗
║   Created by Seyfi ERCAN   ║
╠════════════════════════════╣
║  seyfiercan35@hotmail.com  ║
╠════════════════════════════╣
║        30,May,2020         ║
╚════════════════════════════╝
 */
@Database(entities = [Task::class],version = 1 )
abstract class AppDatabase : RoomDatabase(){
    abstract fun taskDao(): TaskDao

//    companion object {
//        var INSTANCE: AppDatabase? = null
//
//        fun getDatabaseManager(context: Context): AppDatabase? {
//            if (INSTANCE == null) {
//                INSTANCE = Room.databaseBuilder(
//                    context.applicationContext,
//                    AppDatabase::class.java,
//                    "book-database"
//                ).allowMainThreadQueries()
//                    .build()
//            }
//            return INSTANCE
//        }
//
//
//    }
    companion object {
        @Volatile private var instance: AppDatabase? = null
        private val LOCK = Any()

        operator fun invoke(context: Context)= instance ?: synchronized(LOCK){
            instance ?: buildDatabase(context).also { instance = it}
        }

        private fun buildDatabase(context: Context) = Room.databaseBuilder(context,
            AppDatabase::class.java, "task-list.db")
            .build()
    }
}