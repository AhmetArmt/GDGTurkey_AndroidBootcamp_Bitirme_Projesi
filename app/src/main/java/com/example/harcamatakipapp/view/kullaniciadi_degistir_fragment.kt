package com.example.harcamatakipapp.view

import android.annotation.SuppressLint
import android.os.Bundle
import android.text.TextUtils
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.example.harcamatakipapp.R
import kotlinx.android.synthetic.main.fragment_kullaniciadi_degistir_fragment.*
import kotlinx.android.synthetic.main.fragment_main_fragment.*
import kotlinx.android.synthetic.main.fragment_main_fragment.textView_mainCardView_isim
import kotlinx.android.synthetic.main.main_screen_card_view.*


class kullaniciadi_degistir_fragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_kullaniciadi_degistir_fragment, container, false)

    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        }


}

