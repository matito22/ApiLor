package com.example.apilor

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import android.widget.Toast

class AgregarUsuario : AppCompatActivity() {

    lateinit var usernameNuevo: EditText
    lateinit var passwordNuevo: EditText
    lateinit var createUserButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_agregar_usuario)

        usernameNuevo = findViewById<EditText>(R.id.usernameNuevo)
        passwordNuevo = findViewById<EditText>(R.id.passwordNuevo)
        createUserButton = findViewById<Button>(R.id.createUserButton)

        createUserButton.setOnClickListener {
            val nombreUsuario = usernameNuevo.text.toString()
            val passwordUsuario = passwordNuevo.text.toString()

            val nuevoUsuario = Usuarios(nombreUsuario, passwordUsuario)
            AppDataBase.getDataBase(this).UsuariosDao().insert(nuevoUsuario)
            val intentTerminos = Intent(this, TerminosyCondicionesActivity::class.java)
            startActivity(intentTerminos)


        }
    }

}