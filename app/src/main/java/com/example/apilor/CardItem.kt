package com.example.apilor

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

data class CardItem(
    val imageResource: Int,
    val title: String,
    val id: Int)


