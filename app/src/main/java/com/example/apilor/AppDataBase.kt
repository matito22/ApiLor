package com.example.apilor

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [Usuarios::class], version = 1,exportSchema = false)
abstract class AppDataBase : RoomDatabase() {
    abstract fun UsuariosDao(): UsuariosDao

    companion object {
        private var INSTANCIA: AppDataBase? = null
        fun getDataBase(contexto: Context): AppDataBase {
            if (INSTANCIA == null) {
                synchronized(this) {
                    INSTANCIA = Room.databaseBuilder(
                        contexto, AppDataBase::class.java, "base_data_lor"
                    )
                        .allowMainThreadQueries()
                        .fallbackToDestructiveMigration()
                        .build()
                }
            }
            return INSTANCIA!!
        }
    }
}