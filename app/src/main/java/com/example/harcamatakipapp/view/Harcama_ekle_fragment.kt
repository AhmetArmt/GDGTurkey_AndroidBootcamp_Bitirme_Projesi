package com.example.harcamatakipapp.view

import android.content.Context
import android.os.Bundle
import android.text.BoringLayout.make
import android.text.TextUtils
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.fragment.findNavController
import com.example.harcamatakipapp.R
import com.example.harcamatakipapp.model.Harcama
import com.example.harcamatakipapp.viewmodel.Harcama_ekle_fragmentVM
import com.example.harcamatakipapp.viewmodel.Main_fragmentVM
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.fragment_harcama_ekle_fragment.*
import kotlin.coroutines.coroutineContext


class Harcama_ekle_fragment() : Fragment() {
    private lateinit var viewModel : Harcama_ekle_fragmentVM

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_harcama_ekle_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel = ViewModelProviders.of(this).get(Harcama_ekle_fragmentVM::class.java)

        button_harcama_ekle.setOnClickListener {


            if (TextUtils.isEmpty(edittextHarcamaAciklama.text) || TextUtils.isEmpty(edittextHarcamatutar.text)){
                Snackbar.make(it, "Lütfen Tüm Alanları Eksiksiz Doldurun !", Snackbar.LENGTH_SHORT).show()
                return@setOnClickListener
            } else {
                var harcamaTuru: Int = 0
                if (radio_button_Fatura.isChecked) harcamaTuru = 1
                if (radio_button_Kira.isChecked) harcamaTuru = 2
                if (radio_button_Alışveris.isChecked) harcamaTuru = 3
                if (radio_button_Diğer.isChecked) harcamaTuru = 4

                val harcamaAciklama = edittextHarcamaAciklama.text.toString()

                val harcamaTurar = edittextHarcamatutar.text.toString().toFloat()

                var harcamaDoviz : String
                if (radio_button_TL.isChecked) harcamaDoviz = "₺"
                else if (radio_button_Dolar.isChecked) harcamaDoviz = "$"
                else if (radio_button_Euro.isChecked) harcamaDoviz = "€"
                else  harcamaDoviz = "£"

                val eklenecekHarcama =
                    Harcama(harcamaTuru, harcamaAciklama, harcamaTurar, harcamaDoviz)

                viewModel.harcamaEkle(eklenecekHarcama, view.context)

                val action = Harcama_ekle_fragmentDirections.actionHarcamaEkleFragmentToMainFragment()
                findNavController().navigate(action)

                Toast.makeText(view.context,"Harcamaniz Kaydedildi",Toast.LENGTH_SHORT).show()
            }
        }


    }




}