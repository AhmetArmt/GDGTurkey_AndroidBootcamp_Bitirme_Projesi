package com.example.harcamatakipapp.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter

class ViewPagerAdapter(fmanager: FragmentManager,
                       lifecycle: Lifecycle,
                       fList: ArrayList<Fragment>) : FragmentStateAdapter(fmanager,lifecycle) {

   private val fragmentList = fList

    override fun getItemCount(): Int {
        return fragmentList.size
    }

    override fun createFragment(position: Int): Fragment {
        return fragmentList[position]
    }


}