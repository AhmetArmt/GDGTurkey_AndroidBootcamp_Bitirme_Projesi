package com.example.harcamatakipapp.services

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.harcamatakipapp.model.Harcama

@Database(entities = [Harcama::class],version = 1,exportSchema = false)
abstract class HarcamaDatabase : RoomDatabase() {
    abstract val harcamaDao : HarcamaDAO

    companion object {

        @Volatile private var instance : HarcamaDatabase? = null

        operator fun invoke(context: Context) = instance ?: synchronized(this){
            instance ?: harcamaDbOlustur(context).also {
                instance = it
            }
        }

        private fun harcamaDbOlustur(context: Context) = Room.databaseBuilder(
                context.applicationContext,
                HarcamaDatabase::class.java,
                "Harcamalar").build()
    }


}