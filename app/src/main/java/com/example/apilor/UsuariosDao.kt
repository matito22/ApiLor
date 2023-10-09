package com.example.apilor
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface UsuariosDao {
    @Query("SELECT * FROM usuarios_existentes")
    fun getAll():List<Usuarios>
    @Insert
    fun insert(usuarios: Usuarios)
}

