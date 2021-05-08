package com.example.harcamatakipapp.services

import com.example.harcamatakipapp.model.Doviz
import io.reactivex.Single
import retrofit2.Call
import retrofit2.http.GET

interface DovizAPI {

    // BASE -> https://api.ratesapi.io/api/

    // URL -> latest?base=TRY&symbols=GBP,USD,EUR




    @GET("latest?base=TRY&symbols=USD,EUR,GBP")
    fun tryVerisiniAl() : Call<Doviz>

    @GET("latest?base=USD&symbols=TRY,EUR,GBP")
    fun usdVerisiniAl() : Call<Doviz>

    @GET("latest?base=EUR&symbols=TRY,USD,GBP")
    fun eurVerisiniAl() : Call<Doviz>

    @GET("latest?base=GBP&symbols=TRY,USD,EUR")
    fun gbpVerisiniAl() : Call<Doviz>


}