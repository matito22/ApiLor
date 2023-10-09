package com.example.apilor

import com.squareup.moshi.JsonClass

//serializar/deserializar la informacion
@JsonClass(generateAdapter = true)
data class Post(
    var count:Int,
    var results:List<Character>
)


