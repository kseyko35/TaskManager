package com.example.taskmanager.view.activity

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.taskmanager.adapter.TabPagerAdapter
import com.example.taskmanager.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val fragmentAdapter = TabPagerAdapter(
            supportFragmentManager
        )
        binding.mViewPager.adapter = fragmentAdapter
        binding.mTabsMain.setupWithViewPager(binding.mViewPager)



        binding.fab.setOnClickListener {
            val intent = Intent(this@MainActivity, AddTaskActivity::class.java)
            startActivity(intent)
        }
    }
}
