package com.example.harcamatakipapp.splashscreen

import android.content.Context
import android.os.Bundle
import android.os.Handler
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.harcamatakipapp.R
import kotlinx.android.synthetic.main.fragment_splash_screen.*


class SplashScreen : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,savedInstanceState: Bundle?): View? {

        Handler().postDelayed(
            Runnable {
                if (onBoardingbitisChecker()){
                    val action = R.id.action_splashScreen_to_main_fragment
                    findNavController().navigate(action)
                } else {
                    val action = R.id.action_splashScreen_to_viewPagerFragment
                    findNavController().navigate(action)
                }
                     } , 3000)

        return inflater.inflate(R.layout.fragment_splash_screen, container, false)

    }

    private fun onBoardingbitisChecker() : Boolean {
        val sharedPr = requireActivity().getSharedPreferences("sharedPrefDatas", Context.MODE_PRIVATE)

        return sharedPr.getBoolean("onBoardingBitis", false)
    }

}