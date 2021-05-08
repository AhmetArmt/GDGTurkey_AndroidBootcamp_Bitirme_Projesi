package com.example.harcamatakipapp.onborarding.screens

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.viewpager2.widget.ViewPager2
import com.example.harcamatakipapp.R
import kotlinx.android.synthetic.main.fragment_on_boarding_screen1.view.*
import kotlinx.android.synthetic.main.fragment_on_boarding_screen2.view.*


class OnBoardingScreen2 : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_on_boarding_screen2, container, false)

        val viewPagerAction = activity?.findViewById<ViewPager2>(R.id.viewPager)

        view.textViewGec2.setOnClickListener {
            viewPagerAction?.currentItem = 2
        }

        return view
    }

}