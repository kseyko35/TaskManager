package com.example.taskmanager.view.activity

import android.app.DatePickerDialog
import android.os.Bundle
import android.text.TextUtils
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.example.taskmanager.R
import com.example.taskmanager.viewmodel.TaskViewModel
import com.example.taskmanager.databinding.ActivityAddTaskBinding
import com.example.taskmanager.database.entity.Task
import java.text.DateFormat
import java.text.SimpleDateFormat
import java.util.*


class AddTaskActivity : AppCompatActivity(R.layout.activity_add_task) {
    private lateinit var binding: ActivityAddTaskBinding
    private lateinit var taskViewModel: TaskViewModel
    private var taskDate: Date?= null
    private var taskDayType: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAddTaskBinding.inflate(layoutInflater)
        setContentView(binding.root)


        taskViewModel = ViewModelProvider(this).get(TaskViewModel::class.java)
        val calendar = Calendar.getInstance()
        val dateFormat: DateFormat = SimpleDateFormat("dd-MMM-yyyy",Locale.US)

        val today = calendar.time

        calendar.add(Calendar.DAY_OF_MONTH, 1)
        val tomorrow = calendar.time

        val dateSetListener =
            DatePickerDialog.OnDateSetListener { view, year, monthOfYear, dayOfMonth ->
                calendar.set(Calendar.YEAR, year)
                calendar.set(Calendar.MONTH, monthOfYear)
                calendar.set(Calendar.DAY_OF_MONTH, dayOfMonth)
                binding.mDateText.text = dateFormat.format(calendar.time)
                taskDate = calendar.time
                taskDayType = 3
            }



        binding.mTodayCheck.setOnClickListener {

            binding.mDateText.text = dateFormat.format(today)
            taskDate = today
            taskDayType = 1
        }
        binding.mTomorrowCheck.setOnClickListener {

            binding.mDateText.text = dateFormat.format(tomorrow)
            taskDate = tomorrow
            taskDayType = 2
        }
        binding.mNextCheck.setOnClickListener {
            val dialog = DatePickerDialog(
                this, dateSetListener,
                calendar.get(Calendar.YEAR),
                calendar.get(Calendar.MONTH),
                calendar.get(Calendar.DAY_OF_MONTH)
            )
            dialog.datePicker.minDate = calendar.timeInMillis
            dialog.show()
        }
        binding.mAddBtn.setOnClickListener {
            if (TextUtils.isEmpty(binding.mNameTask.text) || TextUtils.isEmpty(binding.mDescriptionTask.text) || taskDayType == 0) {
                Toast.makeText(
                    this,
                    "Everything should filled",
                    Toast.LENGTH_LONG
                ).show()
            } else {
                val taskName = binding.mNameTask.text.toString()
                val taskDescription = binding.mDescriptionTask.text.toString()

                taskViewModel.insert(Task(taskName, taskDescription, taskDate,taskDayType ))
                Toast.makeText(
                    this,
                    "$taskName task is added",
                    Toast.LENGTH_LONG
                ).show()
                onBackPressed()
            }
        }
    }

}
