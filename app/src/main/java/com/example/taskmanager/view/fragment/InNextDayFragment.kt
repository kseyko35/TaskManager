package com.example.taskmanager.view.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.taskmanager.R
import com.example.taskmanager.adapter.TaskListAdapter
import com.example.taskmanager.databinding.FragmentNextDayBinding
import com.example.taskmanager.databinding.FragmentTomorrowBinding
import com.example.taskmanager.viewmodel.TaskViewModel

/**
 * A simple [Fragment] subclass.
 */
class InNextDayFragment : Fragment(R.layout.fragment_next_day) {

    private var fragmentNextDayBinding: FragmentNextDayBinding? = null
    private lateinit var taskViewModel: TaskViewModel

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val binding = FragmentNextDayBinding.bind(view)
        fragmentNextDayBinding = binding
        val adapter =
            TaskListAdapter(requireContext())
        binding.mNextDayRecycler.adapter = adapter
        binding.mNextDayRecycler.layoutManager = LinearLayoutManager(requireContext())

        taskViewModel = ViewModelProvider(this).get(TaskViewModel::class.java)
        taskViewModel.nextDayTask.observe(viewLifecycleOwner, Observer { tasks ->
            tasks.let {
                adapter.setTasks(it)
            }
        })


    }

    override fun onDestroyView() {
        super.onDestroyView()
        fragmentNextDayBinding = null
    }

}
