package com.example.harcamatakipapp.viewmodel

import android.content.Context
import android.view.View
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.navigation.NavDirections
import androidx.navigation.Navigation
import com.example.harcamatakipapp.model.Harcama
import com.example.harcamatakipapp.services.HarcamaDatabase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import kotlin.coroutines.CoroutineContext

class Main_fragmentVM() : ViewModel(), CoroutineScope {

    private val job = Job()
    override val coroutineContext: CoroutineContext
        get() = job + Dispatchers.IO

    // Degiskenler , Sabitler
    val harcamalarListesi = ArrayList<Harcama>()


    fun harcamalariGetir(vmContext : Context) {
        launch {
            val database = HarcamaDatabase(vmContext).harcamaDao
            harcamalarListesi.clear()
            harcamalarListesi.addAll(database.harcamalariGetir())
        }
    }

    fun harcamalariGuncelle(vmContext: Context) {
        launch {
            val database = HarcamaDatabase(vmContext).harcamaDao
            harcamalarListesi.clear()
            harcamalarListesi.addAll(database.harcamalariGetir())
        }
    }


    override fun onCleared() {
        super.onCleared()
        job.cancel()
    }

}