package com.example.harcamatakipapp.view

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
import io.reactivex.disposables.CompositeDisposable
import kotlinx.android.synthetic.main.fragment_kullaniciadi_degistir_fragment.*
import kotlinx.android.synthetic.main.fragment_on_boarding_screen3.*
import retrofit2.*


class Kullaniciadi_degistir_fragment : Fragment() {


    private val disposableConnection = CompositeDisposable()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_kullaniciadi_degistir_fragment, container, false)

    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        buttonKullaniciBilgileriniKaydet.setOnClickListener {
            if (TextUtils.isEmpty(editTextIsimDegistirici.text)) {
                Snackbar.make(view, "Lütfen Tüm Alanları Doldurun !", Snackbar.LENGTH_SHORT).show()
                return@setOnClickListener
            } else {
                val kullaniciAdi = editTextIsimDegistirici.text.toString()


                var kullaniciAdiveCinsiyeti : String

                if (radio_button_kadin.isChecked) kullaniciAdiveCinsiyeti = "$kullaniciAdi Hanım"
                else if (radio_button_erkek.isChecked) kullaniciAdiveCinsiyeti = "$kullaniciAdi Bey"
                else kullaniciAdiveCinsiyeti = kullaniciAdi


                kullaniciAdiGuncelle(kullaniciAdiveCinsiyeti)

                val action = Kullaniciadi_degistir_fragmentDirections.actionKullaniciadiDegistirFragmentToMainFragment()
                findNavController().navigate(action)




            }

        }

        }


    private fun kullaniciAdiGuncelle(isim : String) {
        val sharedPr = requireActivity().getSharedPreferences("sharedPrefDatas",Context.MODE_PRIVATE)
        val editor = sharedPr.edit()
        editor.putString("KullaniciAdi",isim)
        editor.apply()
    }

}

