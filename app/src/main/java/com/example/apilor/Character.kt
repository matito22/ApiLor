package com.example.apilor

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
    var group: String,
    var weapons: List<String>,
    var languages: List<String>,
    var films: List<String>,
    var books: List<String>,
    var url: String
)
