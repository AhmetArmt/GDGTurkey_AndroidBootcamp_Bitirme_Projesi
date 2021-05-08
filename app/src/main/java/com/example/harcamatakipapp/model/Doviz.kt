package com.example.harcamatakipapp.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class Doviz(

   @SerializedName("base")

   var base : String,

   @SerializedName("rates")

   var rates : Rates,

   @SerializedName("date")

   var date : String

   ){

}
