package com.example.harcamatakipapp.viewmodel

import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import android.net.NetworkInfo
import android.os.Build
import android.util.Log
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.harcamatakipapp.model.Doviz
import com.example.harcamatakipapp.model.Harcama
import com.example.harcamatakipapp.services.DovizAPIService
import com.example.harcamatakipapp.services.HarcamaDatabase
import com.google.android.material.snackbar.Snackbar
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

import kotlin.coroutines.CoroutineContext

class Main_fragmentVM() : ViewModel(), CoroutineScope {

    private val job = Job()
    override val coroutineContext: CoroutineContext
        get() = job + Dispatchers.Main

    // Degiskenler , Sabitler
    val harcamalarListesi = MutableLiveData<List<Harcama>>()
    private val dovizApi = DovizAPIService()
    fun refleshDayfaData(vmContext : Context,fragment: Fragment) {
        if (internetKontrolcusu(vmContext)){
            verileriRoomdanGetir(vmContext)
            dolarVerileriInternettenIndir(vmContext,fragment)
            euroVerileriInternettenIndir(vmContext,fragment)
            sterlinVerileriInternettenIndir(vmContext,fragment)
            tlVerileriInternettenIndir(vmContext,fragment)
        }else{
            verileriRoomdanGetir(vmContext)
           Toast.makeText(vmContext,"Internet Bağlantısı Yok",Toast.LENGTH_SHORT).show()
        }

    }



    fun verileriRoomdanGetir(vmContext : Context) {
        launch {
            val database = HarcamaDatabase(vmContext).harcamaDao
            harcamalariEsitle(database.harcamalariGetir())
        }
    }

   private fun dolarVerileriInternettenIndir(vmContext: Context,fragment: Fragment) {
        val sharedPr =fragment.requireActivity().getSharedPreferences("sharedPrefDatas", Context.MODE_PRIVATE)
        dovizApi.getDoviz("USD").enqueue(object : Callback<Doviz> {
            override fun onResponse(call: Call<Doviz>, response: Response<Doviz>) {
                val dovizUsdto = response.body()!!.rates
                val editor = sharedPr.edit()
                editor.putFloat("usdtotl", dovizUsdto.tl)
                editor.putFloat("usdtoeur", dovizUsdto.euro)
                editor.putFloat("usdtogbp", dovizUsdto.sterlin)
                editor.putFloat("usdtousd", 1f)
                Log.e("RETROFIT_LOG : ", "ERISIM SAGLANIYOR")
            }

            override fun onFailure(call: Call<Doviz>, t: Throwable) {
                t.printStackTrace()
            }
        })
    }

   private fun euroVerileriInternettenIndir(vmContext: Context,fragment: Fragment) {
        val sharedPr =fragment.requireActivity().getSharedPreferences("sharedPrefDatas", Context.MODE_PRIVATE)
        dovizApi.getDoviz("EUR").enqueue(object : Callback<Doviz> {
            override fun onResponse(call: Call<Doviz>, response: Response<Doviz>) {
                val dovizEurto = response.body()!!.rates
                val editor = sharedPr.edit()
                editor.putFloat("eurtotl", dovizEurto.tl)
                editor.putFloat("eurtoeur", 1f)
                editor.putFloat("eurtogbp", dovizEurto.sterlin)
                editor.putFloat("eurtousd", dovizEurto.dolar)
                Log.e("RETROFIT_LOG : ", "ERISIM SAGLANIYOR")
            }

            override fun onFailure(call: Call<Doviz>, t: Throwable) {
                t.printStackTrace()
            }
        })
    }

   private fun sterlinVerileriInternettenIndir(vmContext: Context,fragment: Fragment) {
        val sharedPr =fragment.requireActivity().getSharedPreferences("sharedPrefDatas", Context.MODE_PRIVATE)
        dovizApi.getDoviz("GBP").enqueue(object : Callback<Doviz> {
            override fun onResponse(call: Call<Doviz>, response: Response<Doviz>) {
                val dovizGbpto = response.body()!!.rates
                val editor = sharedPr.edit()
                editor.putFloat("gbptotl", dovizGbpto.tl)
                editor.putFloat("gbptoeur", dovizGbpto.euro)
                editor.putFloat("gbptogbp", 1f)
                editor.putFloat("gbptousd", dovizGbpto.dolar)
                Log.e("RETROFIT_LOG : ", "ERISIM SAGLANIYOR")
            }

            override fun onFailure(call: Call<Doviz>, t: Throwable) {
                t.printStackTrace()
            }
        })
    }

   private fun tlVerileriInternettenIndir(vmContext: Context,fragment: Fragment) {
        val sharedPr =fragment.requireActivity().getSharedPreferences("sharedPrefDatas", Context.MODE_PRIVATE)
        dovizApi.getDoviz("TRY").enqueue(object : Callback<Doviz> {
            override fun onResponse(call: Call<Doviz>, response: Response<Doviz>) {
                val dovizTlto = response.body()!!.rates
                val editor = sharedPr.edit()
                editor.putFloat("tltotl", 1f)
                editor.putFloat("tltoeur", dovizTlto.euro)
                editor.putFloat("tltogbp", dovizTlto.sterlin)
                editor.putFloat("tltousd", dovizTlto.dolar)
                Log.e("RETROFIT_LOG : ", "ERISIM SAGLANIYOR")
            }

            override fun onFailure(call: Call<Doviz>, t: Throwable) {
                t.printStackTrace()
            }
        })
    }


    private fun harcamalariEsitle(harcamaList : List<Harcama>) {
        harcamalarListesi.value = harcamaList
    }



    private fun internetKontrolcusu(context: Context): Boolean {
        var result = false
        val connectivityManager =
            context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            val networkCapabilities = connectivityManager.activeNetwork ?: return false
            val actNw =
                connectivityManager.getNetworkCapabilities(networkCapabilities) ?: return false
            result = when {
                actNw.hasTransport(NetworkCapabilities.TRANSPORT_WIFI) -> true
                actNw.hasTransport(NetworkCapabilities.TRANSPORT_CELLULAR) -> true
                actNw.hasTransport(NetworkCapabilities.TRANSPORT_ETHERNET) -> true
                else -> false
            }
        } else {
            connectivityManager.activeNetworkInfo?.run {
                result = when (type) {
                    ConnectivityManager.TYPE_WIFI -> true
                    ConnectivityManager.TYPE_MOBILE -> true
                    ConnectivityManager.TYPE_ETHERNET -> true
                    else -> false
                }

            }
        }
        return result
    }



    override fun onCleared() {
        super.onCleared()
        job.cancel()
    }

}

