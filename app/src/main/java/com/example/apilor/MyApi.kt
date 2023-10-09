package com.example.apilor

import retrofit2.Call
import retrofit2.http.GET


interface MyApi {
    @GET("characters/")
    fun getCharacters(): Call<Post>
}