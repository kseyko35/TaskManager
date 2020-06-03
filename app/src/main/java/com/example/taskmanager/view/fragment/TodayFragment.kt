package com.example.taskmanager.view.fragment

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.taskmanager.R
import com.example.taskmanager.adapter.TaskListAdapter
import com.example.taskmanager.databinding.FragmentTodayBinding
import com.example.taskmanager.viewmodel.TaskViewModel


/**
 * A simple [Fragment] subclass.
 */
class TodayFragment : Fragment(R.layout.fragment_today) ,TaskListAdapter.OnClickListener{
    private var fragmentTodayBinding: FragmentTodayBinding? = null
    private lateinit var taskViewModel: TaskViewModel

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val binding = FragmentTodayBinding.bind(view)
        fragmentTodayBinding = binding
        val adapter = TaskListAdapter(requireContext())

        binding.mTodayRecycler.adapter = adapter
        binding.mTodayRecycler.layoutManager = LinearLayoutManager(requireContext())

        taskViewModel = ViewModelProvider(this).get(TaskViewModel::class.java)
        taskViewModel.todayTask.observe(viewLifecycleOwner, Observer { tasks ->
            tasks.let {
                adapter.setTasks(it)
            }
        })

    }

    override fun onDestroyView() {
        super.onDestroyView()
        fragmentTodayBinding = null
    }

    override fun onTaskClick(position: Int) {
        Toast.makeText(
            requireContext(),
            position,
            Toast.LENGTH_LONG
        ).show()
    }

}
