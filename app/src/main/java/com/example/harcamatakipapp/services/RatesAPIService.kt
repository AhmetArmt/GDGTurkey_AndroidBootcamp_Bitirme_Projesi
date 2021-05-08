package com.example.harcamatakipapp.services

import com.example.harcamatakipapp.model.Rates
import io.reactivex.Single
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create

class RatesAPIService {

    // BASE -> https://api.ratesapi.io/api/
    // URL -> latest?base=TRY&symbols=GBP,USD,EUR

    private val BaseURL = "https://api.ratesapi.io/api/"

    private val retrofitApi = Retrofit.Builder()
        .baseUrl(BaseURL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()
        .create(RatesAPI::class.java)

    fun getRate() : Call<Rates> {
        return retrofitApi.rateVerisiniAl()
    }

}