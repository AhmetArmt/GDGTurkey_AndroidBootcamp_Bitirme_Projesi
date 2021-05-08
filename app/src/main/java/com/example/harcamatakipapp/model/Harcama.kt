package com.example.harcamatakipapp.model

import android.text.Editable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "harcamalarTablosu")
data class Harcama(

    @ColumnInfo(name ="harcamaTuru")
    val harcamaTuru: Int, // 1 -> Fatura  2-> Kira  3 -> Alisveris  4 -> Diger
    @ColumnInfo(name ="harcamaBaslik")
    var harcamaBaslik: String,
    @ColumnInfo(name ="harcamaTutari")
    var harcamaTutari: Float,
    @ColumnInfo(name = "harcamaDoviz")
    val harcamaDoviz: String //
                    ) {
    @PrimaryKey(autoGenerate = true)
    var harcamaId : Int = 0

}