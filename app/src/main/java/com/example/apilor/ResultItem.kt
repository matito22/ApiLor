package com.example.apilor

import com.squareup.moshi.JsonClass


open class ResultItem {

    @JsonClass(generateAdapter = true)
    data class Character(
        var id: Int,
        var name: String,
        var realm: String,
        var height: String,
        var hair_color: String,
        var eye_color: String,
        var date_of_birth: String,
        var date_of_death: String,
        var gender: String,
        var species: String,
        var race: String,
        var group: String
    ) : ResultItem()

    @JsonClass(generateAdapter = true)
    data class Realm(
        var id: Int,
        var name: String,
        var founded_date: String,
        var location: String,
    ) : ResultItem()
}





