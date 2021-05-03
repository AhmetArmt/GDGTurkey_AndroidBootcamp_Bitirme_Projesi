package com.example.harcamatakipapp.viewmodel

import android.view.View
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.navigation.NavDirections
import androidx.navigation.Navigation
import com.example.harcamatakipapp.model.Harcama

class Main_fragmentVM : ViewModel() {

    val harcamalarListesi = ArrayList<Harcama>()

    fun refreshHarcamalar(){

        val harcamaList = arrayListOf<Harcama>()
        harcamalarListesi.clear()
        harcamalarListesi.addAll(harcamaList)
    }

    fun gecisEkle(action: NavDirections, view: View) {
            Navigation.findNavController(view).navigate(action)
    }


}