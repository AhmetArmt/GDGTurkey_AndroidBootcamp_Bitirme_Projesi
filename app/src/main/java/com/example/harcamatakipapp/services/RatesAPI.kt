package com.example.harcamatakipapp.services

import com.example.harcamatakipapp.model.Rates
import io.reactivex.Single
import retrofit2.Call
import retrofit2.http.GET

interface RatesAPI {

   // BASE -> https://api.ratesapi.io/api/

   // URL -> latest?base=TRY&symbols=GBP,USD,EUR


    // GET
    @GET("latest?base=TRY&symbols=GBP,USD,EUR")
    fun rateVerisiniAl() : Call<Rates>






}