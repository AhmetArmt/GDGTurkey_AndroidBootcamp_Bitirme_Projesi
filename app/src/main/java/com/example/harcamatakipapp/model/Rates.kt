package com.example.harcamatakipapp.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class Rates(
        @SerializedName("GBP")

        var sterlin : Float,

        @SerializedName("EUR")

        var euro : Float,

        @SerializedName("USD")

        var dolar : Float,

        @SerializedName("TRY")

        var tl : Float,
){

}
