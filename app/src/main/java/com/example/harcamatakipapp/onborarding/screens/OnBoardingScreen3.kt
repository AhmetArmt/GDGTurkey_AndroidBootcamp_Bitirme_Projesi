package com.example.harcamatakipapp.onborarding.screens

import android.content.Context
import android.os.Bundle
import android.text.TextUtils
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.harcamatakipapp.R
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.fragment_kullaniciadi_degistir_fragment.*
import kotlinx.android.synthetic.main.fragment_on_boarding_screen3.*


class OnBoardingScreen3 : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_on_boarding_screen3, container, false)


    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        onBbuttonKullaniciBilgileriniKaydetVeBasla.setOnClickListener {
            if (TextUtils.isEmpty(onBeditTextIsimDegistirici.text)) {
                Snackbar.make(view, "Lütfen Tüm Alanları Doldurun !", Snackbar.LENGTH_SHORT).show()
                return@setOnClickListener
            } else {
                val action = R.id.action_viewPagerFragment_to_main_fragment
                findNavController().navigate(action)

                val kullaniciAdi = onBeditTextIsimDegistirici.text.toString()
                var kullaniciAdiveCinsiyeti : String

                if (onBradio_button_kadin.isChecked) kullaniciAdiveCinsiyeti = "$kullaniciAdi Hanım"
                else if (onBradio_button_erkek.isChecked) kullaniciAdiveCinsiyeti = "$kullaniciAdi Bey"
                else kullaniciAdiveCinsiyeti = kullaniciAdi

                onBoardingbitis(kullaniciAdiveCinsiyeti)

            }
        }
    }

    private fun onBoardingbitis(isim : String){
        val sharedPr = requireActivity().getSharedPreferences("sharedPrefDatas",Context.MODE_PRIVATE)
        val editor = sharedPr.edit()
        editor.putBoolean("onBoardingBitis",true)
        // Isim kaydi
        editor.putString("KullaniciAdi",isim)
        editor.apply()
    }

}


