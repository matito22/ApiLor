package com.example.apilor

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.widget.Toolbar
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class CardActivity : AppCompatActivity() ,CardItemClickListener{
    lateinit var rvCard: RecyclerView
    lateinit var cardItems: CardAdapter
    lateinit var rvCard2: RecyclerView
    lateinit var secondCardItems:CardAdapter
    lateinit var toolbar: Toolbar

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_item_card)

        rvCard=findViewById(R.id.rvCard)
        cardItems= CardAdapter(getCardItems(), this,this)
        rvCard.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        rvCard.adapter = cardItems
        toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)
        supportActionBar!!.title = resources.getString(R.string.app_name)

        rvCard2= findViewById(R.id.rvCard2)
        secondCardItems = CardAdapter(getSecondCardItems(), this,this)
        rvCard2.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        rvCard2.adapter = secondCardItems



    }



    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == R.id.list_item1) {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            return true

        }
        return super.onOptionsItemSelected(item)
    }

    override fun onCardItemClick(cardItem: CardItem) {
        val intent = Intent(this, ApiExample::class.java)
        intent.putExtra("cardItemTitle", cardItem.title)
        startActivity(intent)
    }

    private fun getCardItems(): MutableList<CardItem> {
        val items=mutableListOf<CardItem>()
        items.add(CardItem(R.drawable.hobbiton, "The Shire",1))
        items.add(CardItem(R.drawable.arnor, "Arnor",2))
        items.add(CardItem(R.drawable.valinor, "Valinor",3))
        items.add(CardItem(R.drawable.woodlandrealm, "Woodland Realm",5))
        items.add(CardItem(R.drawable.mountain, "Lonely Mountain",6))
        items.add(CardItem(R.drawable.osgiliath, "Anórien",7))

        return items
    }

    private fun getSecondCardItems(): MutableList<CardItem> {
        val items = mutableListOf<CardItem>()
        items.add(CardItem(R.drawable.aragorn, "Aragorn II",5))
        items.add(CardItem(R.drawable.bilbo, "Bilbo Baggins",4))
        items.add(CardItem(R.drawable.boromir, "Boromir",10))
        items.add(CardItem(R.drawable.frodo, "Frodo Baggins",1))
        items.add(CardItem(R.drawable.gandalf, "Gandalf",3))
        items.add(CardItem(R.drawable.gimli, "Gimli",9))
        items.add(CardItem(R.drawable.legolas, "Legolas",8))
        items.add(CardItem(R.drawable.merry, "Meriadoc Brandybuck",6))
        items.add(CardItem(R.drawable.pippin, "Peregrin Took",7))
        items.add(CardItem(R.drawable.sam, "Samwise Gamgee",2))

        return items
    }

}


