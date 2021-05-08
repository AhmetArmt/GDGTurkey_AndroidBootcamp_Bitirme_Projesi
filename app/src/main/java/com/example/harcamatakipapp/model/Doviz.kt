package com.example.harcamatakipapp.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.ForeignKey.CASCADE
import androidx.room.PrimaryKey
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
   @PrimaryKey(autoGenerate = true)
   var dovizId : Int = 0

}
