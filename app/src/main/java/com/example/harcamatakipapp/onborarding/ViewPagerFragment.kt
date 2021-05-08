package com.example.harcamatakipapp.onborarding

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.harcamatakipapp.R
import com.example.harcamatakipapp.adapter.ViewPagerAdapter
import com.example.harcamatakipapp.onborarding.screens.OnBoardingScreen1
import com.example.harcamatakipapp.onborarding.screens.OnBoardingScreen2
import com.example.harcamatakipapp.onborarding.screens.OnBoardingScreen3
import kotlinx.android.synthetic.main.fragment_view_pager.view.*


class ViewPagerFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_view_pager, container, false)

        val frList = arrayListOf<Fragment>(OnBoardingScreen1(), OnBoardingScreen2(), OnBoardingScreen3())

        val vpAdapter = ViewPagerAdapter(requireActivity().supportFragmentManager, lifecycle, frList)

        view.viewPager.adapter = vpAdapter

        return view
    }

}


