package com.example.apilor

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import android.widget.Toast
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class ApiExample : AppCompatActivity() {
    private lateinit var tvServicioRest : TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_api_example)

        val api=RetrofitClient.retrofit.create(MyApi::class.java)
        val callPost = api.getCharacters()
        callPost.enqueue(object : Callback<Post> {
            override fun onResponse(call: Call<Post>, response: Response<Post>) {
                if (response.isSuccessful) {
                    val post = response.body()
                    if (post != null) {
                        tvServicioRest = findViewById(R.id.tvServicioRest)
                        tvServicioRest.text = post.toString()

                    }
                } else {
                    // Hubo un problema en la respuesta, por ejemplo, código de respuesta no 200 OK
                    Log.e("Response", "Error en la solicitud: ${response.code()}")
                }
            }

            override fun onFailure(call: Call<Post>, t: Throwable) {
                // Manejar error de red (por ejemplo, falta de conexión)
                Log.e("ERROR", t.message ?: "")
            }
        })
    }
}

