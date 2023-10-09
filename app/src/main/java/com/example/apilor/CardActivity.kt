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
        startActivity(intent)
    }

    private fun getCardItems(): MutableList<CardItem> {
        val items=mutableListOf<CardItem>()
        items.add(CardItem(R.drawable.gondolin, "gondolin",1))
        items.add(CardItem(R.drawable.rivendel, "rivendel",2))
        items.add(CardItem(R.drawable.mapa, "minas tirith",3))
        items.add(CardItem(R.drawable.osgiliath, "osgiliath",4))
        items.add(CardItem(R.drawable.bree, "bree",5))
        items.add(CardItem(R.drawable.edoras, "edoras",6))
        items.add(CardItem(R.drawable.hobbiton, "hobbiton",7))
        return items
    }

    private fun getSecondCardItems(): MutableList<CardItem> {
        val items = mutableListOf<CardItem>()
        items.add(CardItem(R.drawable.aragorn, "aragorn",5))
        items.add(CardItem(R.drawable.bilbo, "bilbo baggins",4))
        items.add(CardItem(R.drawable.boromir, "boromir",10))
        items.add(CardItem(R.drawable.frodo, "frodo baggins",1))
        items.add(CardItem(R.drawable.gandalf, "gandalf",3))
        items.add(CardItem(R.drawable.gimli, "gimli",9))
        items.add(CardItem(R.drawable.legolas, "legolas",8))
        items.add(CardItem(R.drawable.merry, "merry",6))
        items.add(CardItem(R.drawable.pippin, "pippin",7))
        items.add(CardItem(R.drawable.sam, "sam gamgee",2))

        return items
    }

}


