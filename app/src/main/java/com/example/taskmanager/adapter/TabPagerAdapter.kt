package com.example.taskmanager.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.example.taskmanager.view.fragment.InNextDayFragment
import com.example.taskmanager.view.fragment.TodayFragment
import com.example.taskmanager.view.fragment.TomorrowFragment


/**     Code with ❤
╔════════════════════════════╗
║   Created by Seyfi ERCAN   ║
╠════════════════════════════╣
║  seyfiercan35@hotmail.com  ║
╠════════════════════════════╣
║        30,May,2020         ║
╚════════════════════════════╝
 */

class TabPagerAdapter(fm: FragmentManager) :
    FragmentPagerAdapter(fm, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) {


    override fun getItem(position: Int): Fragment {
        return when (position) {
            0 -> TodayFragment()
            1 -> TomorrowFragment()
            else -> {
                return InNextDayFragment()
            }
        }
    }

    override fun getCount(): Int {
        return 3
    }

    override fun getPageTitle(position: Int): CharSequence? {
        return when (position) {
            0 -> "Today"
            1 -> "Tomorrow"
            else -> {
                return "Next Days"
            }
        }
    }
}