package com.example.harcamatakipapp.viewmodel

import android.content.Context
import androidx.lifecycle.ViewModel
import com.example.harcamatakipapp.model.Harcama
import com.example.harcamatakipapp.services.HarcamaDatabase
import kotlinx.android.synthetic.main.fragment_harcama_ekle_fragment.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import kotlin.coroutines.CoroutineContext

class Harcama_ekle_fragmentVM : ViewModel(), CoroutineScope {

    private val job = Job()

    override val coroutineContext: CoroutineContext
    get() = job + Dispatchers.Main



    fun harcamaEkle(harcama : Harcama, vmContext : Context) {
        launch {
           val database = HarcamaDatabase(vmContext.applicationContext).harcamaDao
            database.harcamaYukle(harcama)
        }
    }


    override fun onCleared() {
        super.onCleared()
        job.cancel()
    }


}