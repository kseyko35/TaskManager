package com.example.taskmanager

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.taskmanager.database.AppDatabase
import com.example.taskmanager.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    //    var databaseManager: AppDatabase? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
//        val db = Room.databaseBuilder(
//            applicationContext,
//            AppDatabase::class.java, "task-list.db"
//        ).build()
        val db = AppDatabase(this)
        val fragmentAdapter = TabPagerAdapter(supportFragmentManager)
        binding.mViewPager.adapter = fragmentAdapter
        binding.mTabsMain.setupWithViewPager(binding.mViewPager)

//        binding.fab.setOnClickListener {
//            val addTaskFragment: Fragment = AddTaskFragment()
//
//            val transaction =
//                supportFragmentManager.beginTransaction()
//            transaction.replace(R.id.fragment_container, addTaskFragment) // give your fragment container id in first parameter
//            transaction.addToBackStack(null) // if written, this transaction will be added to backstack
//            transaction.commit()
//        }


//        binding.mAddBtn.setOnClickListener {
//            var taskName = binding.mNameTask.text.toString()
//            var taskDescription = binding.mDescriptionTask.text.toString()
//            var data : List<Task>
//            GlobalScope.launch {
//                db.taskDao().insertAll(Task(taskName, taskDescription))
//                data = db.taskDao().getAllTask()
//
//                data.forEach {
//                    println(it.taskName)
//                }
//                this@MainActivity.runOnUiThread(java.lang.Runnable {
//                    binding.mResultText.text=data.size.toString()
//                })
//
//            }
//
//
//        }
//        binding.mFindBtn.setOnClickListener {
//            var findTask = binding.mFindText.toString()
//
////            GlobalScope.launch {
////                var data = db.taskDao().findByTitle(findTask)
////
////                this@MainActivity.runOnUiThread(java.lang.Runnable {
////                    binding.mResultText.text=data.taskDescription
////                })
////
////            }
//
//        }


//        databaseManager = AppDatabase.getDatabaseManager(this)
//        databaseManager?.taskDao()?.insertAll(Task("asasd","adsasdasdasdasdasd"))
//
//        var result=databaseManager?.taskDao()?.getAllTask()
    }
}
