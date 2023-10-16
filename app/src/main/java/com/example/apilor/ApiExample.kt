package com.example.apilor

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.Dispatchers

import kotlinx.coroutines.launch



class ApiExample : AppCompatActivity() {
    private lateinit var tvServicioRest: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_api_example)

        tvServicioRest = findViewById(R.id.tvServicioRest)
        val cardItemTitle = intent.getStringExtra("cardItemTitle")



        lifecycleScope.launch(Dispatchers.IO) {
            try {
                launch(Dispatchers.Main) {
                    Toast.makeText(this@ApiExample, "Realizando llamada en segundo plano", Toast.LENGTH_SHORT).show()
                }

                val api = RetrofitClient.retrofit.create(MyApi::class.java)
                val response = api.getCharacters().execute()




                if (response.isSuccessful) {
                    val post = response.body()

                    if (post != null) {

                        val character = post.results.find { it.name == cardItemTitle }

                        if (character != null) {

                            val characterInfo = "ID: ${character.id}\n\n" +
                            "Nombre: ${character.name}\n\n" +
                                    "Reino: ${character.realm}\n\n" +
                                    "Altura: ${character.height}\n\n" +
                                    "Color de cabello: ${character.hair_color}\n\n" +
                                    "Color de ojos: ${character.eye_color}\n\n" +
                                    "Fecha de nacimiento: ${character.date_of_birth}\n\n" +
                                    "Fecha de defunción: ${character.date_of_death}\n\n" +
                                    "Género: ${character.gender}\n\n" +
                                    "Especie: ${character.species}\n\n" +
                                    "Raza: ${character.race}\n\n" +
                                    "Grupo: ${character.group}\n"
                            launch(Dispatchers.Main) {
                                tvServicioRest.text = characterInfo
                            }
                        }else{
                            val response2= api.getRealms().execute()
                            if(response2.isSuccessful){
                                val post2=response2.body()
                                if(post2!=null){
                                    val realm=post2.results.find { it.name == cardItemTitle }
                                    if(realm != null){
                                        val realmInfo = "ID: ${realm.id}\n\n" +
                                                "Nombre del Reino: ${realm.name}\n\n" +
                                                "Fecha de Fundación: ${realm.founded_date}\n\n" +
                                                "Ubicación: ${realm.location}\n"
                                        launch(Dispatchers.Main) {
                                            tvServicioRest.text = realmInfo
                                        }
                                    }else{
                                        launch(Dispatchers.Main) {
                                            tvServicioRest.text = "No se encontró información para el título: $cardItemTitle"
                                        }
                                    }
                                }
                            }else{
                                Log.e("ApiExample", "La respuesta de la API de reinos es nula.")
                            }
                        }
                    }
                }



            } catch (e: Exception) {
                // Manejar error de red u otros errores
                Log.e("ERROR", e.message ?: "")
            }
        }
    }
}