package com.example.harcamatakipapp.services

import com.example.harcamatakipapp.model.Doviz
import io.reactivex.Single
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

class DovizAPIService {

    // BASE -> https://api.ratesapi.io/api/
    // URL -> latest?base=TRY&symbols=GBP,USD,EUR

    private val BaseURL = "https://api.ratesapi.io/api/"

    private val retrofitApi = Retrofit.Builder()
        .baseUrl(BaseURL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()
        .create(DovizAPI::class.java)

    fun getDoviz(dovizTuru : String) : Call<Doviz> {
        if (dovizTuru == "TRY") return retrofitApi.tryVerisiniAl()
        if (dovizTuru == "EUR") return retrofitApi.eurVerisiniAl()
        if (dovizTuru == "USD") return retrofitApi.usdVerisiniAl()
        if (dovizTuru == "GBP") return retrofitApi.gbpVerisiniAl()
        else return retrofitApi.tryVerisiniAl()
    }

}