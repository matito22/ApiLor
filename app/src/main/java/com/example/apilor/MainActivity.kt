package com.example.apilor

import android.app.Notification
import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import android.widget.Toast
import androidx.core.app.ActivityCompat
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import androidx.core.content.ContentProviderCompat.requireContext

class MainActivity : AppCompatActivity() {
    lateinit var username: EditText
    lateinit var password: EditText
    lateinit var loginButton: Button
    lateinit var rememberMe: CheckBox
    lateinit var btnRegistrar: Button
    private val CHANNEL_ID: String ="Recordar Usuario"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        username = findViewById<EditText>(R.id.username)
        password = findViewById<EditText>(R.id.password)
        loginButton = findViewById<Button>(R.id.loginButton)
        rememberMe = findViewById<CheckBox>(R.id.rememberMe)
        btnRegistrar = findViewById<Button>(R.id.signUpLink)

        var preferencias = getSharedPreferences(resources.getString((R.string.sp_credenciales)), MODE_PRIVATE)
        var usuarioGuardado = preferencias.getString(resources.getString((R.string.nombre_usuario)), "")
        var passwordGuardado = preferencias.getString(resources.getString((R.string.password_usuario)), "")


        btnRegistrar.setOnClickListener {
            val intentTerminos = Intent(this, AgregarUsuario::class.java)
            startActivity(intentTerminos)
        }


        loginButton.setOnClickListener {
            // Obtener datos ingresados por el usuario
            val nombreUsuario = username.text.toString()
            val passwordUsuario = password.text.toString()

            if (nombreUsuario.isEmpty() || passwordUsuario.isEmpty()) {
                Toast.makeText(this, "Faltan datos", Toast.LENGTH_SHORT).show()
            } else {
                // Verificar si el usuario existe en la base de datos
                val database = AppDataBase.getDataBase(this)
                val usuariosDao = database.UsuariosDao()
                val usuarioExistente = usuariosDao.getAll().find { it.userName == nombreUsuario }

                /*if(rememberMe.isChecked){
                    val notificacion= crearNotificacion()
                    if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){
                        createChannel()
                        NotificationManagerCompat.from(this).notify(1, notificacion)
                    }

                }*/

                if (usuarioExistente != null) {
                    // El usuario ya existe en la base de datos
                    Toast.makeText(this, "Bienvenido/a $nombreUsuario", Toast.LENGTH_SHORT).show()
                    val intent = Intent(this, CardActivity::class.java)
                    startActivity(intent)
                } else {

                    Toast.makeText(
                        this,
                        "El usuario no ha sido creado",
                        Toast.LENGTH_SHORT
                    ).show()
                }
            }

        }


        }

    private fun crearNotificacion(): Notification{
        return NotificationCompat.Builder(this,CHANNEL_ID)
            .setSmallIcon(R.drawable.baseline_check_24)
            .setContentTitle("Ejemplo")
            .setContentText("ES UNA MUESTRA")
            .setPriority(NotificationCompat.PRIORITY_HIGH)
            .build()
    }

    private fun saludarUsuario(nombreUsuario: String) {
        Toast.makeText(this, "Bienvenido/a $nombreUsuario", Toast.LENGTH_SHORT).show()
    }

    private fun createChannel() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val importance = NotificationManager.IMPORTANCE_LOW
            val channel = NotificationChannel(CHANNEL_ID, "Recordar Usuario", importance)
            channel.description = "Se mostrará al indicar Recordar Usuario"
            val notificationManager = getSystemService(NOTIFICATION_SERVICE) as NotificationManager
            notificationManager.createNotificationChannel(channel)
        }
    }


    }









