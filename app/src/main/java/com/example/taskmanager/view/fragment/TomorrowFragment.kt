package com.example.taskmanager.view.fragment

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.taskmanager.R
import com.example.taskmanager.adapter.TaskListAdapter
import com.example.taskmanager.databinding.FragmentTomorrowBinding
import com.example.taskmanager.viewmodel.TaskViewModel



class TomorrowFragment : Fragment(R.layout.fragment_tomorrow) {
    private var fragmentTomorrowBinding: FragmentTomorrowBinding? = null
    private lateinit var taskViewModel: TaskViewModel

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val binding = FragmentTomorrowBinding.bind(view)
        fragmentTomorrowBinding = binding
        val adapter =
            TaskListAdapter(requireContext())
        binding.mTomorrowRecycler.adapter = adapter
        binding.mTomorrowRecycler.layoutManager = LinearLayoutManager(requireContext())

        taskViewModel = ViewModelProvider(this).get(TaskViewModel::class.java)
        taskViewModel.tomorrowTask.observe(viewLifecycleOwner, Observer { tasks ->
            tasks.let {
                adapter.setTasks(it)
            }
        })
    }

    override fun onDestroyView() {
        super.onDestroyView()
        fragmentTomorrowBinding = null
    }
}
