package com.example.harcamatakipapp.viewmodel

import android.content.Context
import android.view.View
import androidx.lifecycle.LiveData
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

class Harcama_detayi_fragmentVM() : ViewModel(), CoroutineScope {

    private val job = Job()
    override val coroutineContext: CoroutineContext
        get() = job + Dispatchers.Main

    val harcamaLiveData = MutableLiveData<Harcama>()


        fun harcamaDetayiniGetir(context : Context, harcamaId : Int){
            launch {
                val dao = HarcamaDatabase(context).harcamaDao
                val harcama = dao.idyeGoreHarcamaGetir(harcamaId)
                harcamaLiveData.value = harcama
            }
        }

        fun harcamaSil(context: Context, harcamaId : Int) {
            launch {
                val dao = HarcamaDatabase(context).harcamaDao
                dao.idyeGoreHarcamaSil(harcamaId)
            }
        }

        fun gecisEkle(action: NavDirections, view: View) {
        Navigation.findNavController(view).navigate(action)
    }


    override fun onCleared() {
        super.onCleared()
        job.cancel()
    }



}