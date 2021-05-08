package com.example.harcamatakipapp.services

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.example.harcamatakipapp.model.Harcama

@Dao
interface HarcamaDAO {

    @Insert
    suspend fun harcamaYukle(harcama : Harcama)

    @Query("SELECT * FROM harcamalarTablosu ORDER BY harcamaId DESC")
    suspend fun harcamalariGetir() : List<Harcama>

    @Query("SELECT * FROM harcamalarTablosu WHERE harcamaId =:id")
    suspend fun idyeGoreHarcamaGetir(id : Int) : Harcama

    @Query("DELETE FROM harcamalarTablosu WHERE harcamaId =:id")
    suspend fun idyeGoreHarcamaSil(id : Int)

    @Query("UPDATE harcamalarTablosu SET harcamaDoviz =:harcamadoviz WHERE harcamaId = :id")
    suspend fun updateHarcamaDoviz(harcamadoviz : String, id : Int)

    @Query("UPDATE harcamalarTablosu SET harcamaTutari =:harcamatutari WHERE harcamaId = :id")
    suspend fun updateHarcamaTutar(harcamatutari : Float, id : Int)
}