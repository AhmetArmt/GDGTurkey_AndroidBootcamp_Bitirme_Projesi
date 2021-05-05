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
    val harcamaBaslik: String,
    @ColumnInfo(name ="harcamaTutari")
    val harcamaTutari: Long,
    @ColumnInfo(name = "harcamaDoviz")
    val harcamaDoviz: Int // 1 -> TL  2 -> Dolar  3 -> Euro  4 -> Sterlin
                    ) {
    @PrimaryKey(autoGenerate = true)
    var harcamaId : Int = 0

}