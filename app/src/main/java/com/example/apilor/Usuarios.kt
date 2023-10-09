package com.example.apilor

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "usuarios_existentes")
data class Usuarios (
    @ColumnInfo(name="userName") val userName:String,
    @ColumnInfo(name="passwordUser") val passwordUser:String
)
{
    @PrimaryKey(autoGenerate = true)var id:Long= 0
}


