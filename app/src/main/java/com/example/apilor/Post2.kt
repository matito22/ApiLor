package com.example.apilor

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Post2(
    var count:Int,
    var results:List<ResultItem.Realm>
)
