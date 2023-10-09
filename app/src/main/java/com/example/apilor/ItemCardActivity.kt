package com.example.apilor


import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView


class ItemCardActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_card_item)


        val cardView = findViewById<CardView>(R.id.cardVieew)

       cardView.setOnClickListener{
         val intent = Intent(this, TerminosyCondicionesActivity::class.java)
        startActivity(intent)
       }
    }

}