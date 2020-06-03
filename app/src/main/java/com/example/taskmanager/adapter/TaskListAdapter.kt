package com.example.taskmanager.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.taskmanager.databinding.TaskItemBinding
import com.example.taskmanager.database.entity.Task
import java.text.DateFormat
import java.text.SimpleDateFormat
import java.util.*


/**     Code with ❤
╔════════════════════════════╗
║   Created by Seyfi ERCAN   ║
╠════════════════════════════╣
║  seyfiercan35@hotmail.com  ║
╠════════════════════════════╣
║        01,June,2020        ║
╚════════════════════════════╝
 */

class TaskListAdapter internal constructor(context: Context) :
    RecyclerView.Adapter<TaskListAdapter.TaskViewHolder>() {

    private val inflater: LayoutInflater = LayoutInflater.from(context)
    private var tasks = emptyList<Task>() // Cached copy of task
    private val dateFormat: DateFormat = SimpleDateFormat("dd-MMMM-yyyy", Locale.US)


    inner class TaskViewHolder(val binding: TaskItemBinding) :
        RecyclerView.ViewHolder(binding.root) {

//        override fun onClick(v: View?) {
//            onClickListener.onTaskClick(position)
//        }
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TaskViewHolder {
        val itemView = TaskItemBinding.inflate(inflater, parent, false)
        return TaskViewHolder(itemView)
    }

    override fun getItemCount(): Int = tasks.size

    override fun onBindViewHolder(holder: TaskViewHolder, position: Int) {
        val current: Task = tasks[position]

        holder.binding.mTextName.text = current.taskName
        holder.binding.mTextDescription.text = current.taskDescription
        if (current.taskDayType == 1 || current.taskDayType == 2)
            holder.binding.mTextDate.visibility = View.GONE
        else holder.binding.mTextDate.text = dateFormat.format(current.taskDate)
//        holder.itemView.setOnClickListener{
//            getTaskAt(position)
//            AlertDialog.Builder()
//                .setCancelable(false)
//                .setTitle("Alert Dialog")
//                .setMessage("This is alert Dialog Message Sample text")
//                .setIcon(android.R.drawable.ic_dialog_alert)
//                .setNegativeButton("Close", DialogInterface.OnClickListener { dialog, which ->
//                    print("asdasadasads")
//                }).setPositiveButton("Ok", DialogInterface.OnClickListener
//                { dialog, which ->
//                    print("asdasadasads")
//                }).create().show()
//        }

    }
    interface OnClickListener{
        fun onTaskClick(position: Int)
    }



    internal fun setTasks(tasks: List<Task>) {
        this.tasks = tasks
        notifyDataSetChanged()
    }
    fun getTaskAt(position: Int): Task {
        return tasks[position]
    }


}