package com.example.harcamatakipapp.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Harcama (
                    @PrimaryKey(autoGenerate = true)
                    val harcamaId : Int = 0,
                    @ColumnInfo(name ="harcamaTuru")
                    val harcamaTuru : Int,
                    @ColumnInfo(name ="harcamaBaslik")
                    val harcamaBaslik : String,
                    @ColumnInfo(name ="harcamaTutari")
                    val harcamaTutari : Long
                    )
{

}