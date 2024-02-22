package com.example.singleactivity.view.onBoarding

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import androidx.fragment.app.FragmentStatePagerAdapter
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter

class ViewPagerAdapter(
    fragmentlist: java.util.ArrayList<Fragment>,
    supportFragmentManager: FragmentManager,
    lifecycle: Lifecycle
    ): FragmentStateAdapter(supportFragmentManager,lifecycle) {

        private  var list = fragmentlist
    override fun getItemCount(): Int {
        return   list.size
    }

    override fun createFragment(position: Int): Fragment {
        return list[position]
    }

}