package com.example.apilor

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.widget.Toolbar

class TerminosyCondicionesActivity : AppCompatActivity() {

    private lateinit var btnAceptarTerminos: Button
    private lateinit var toolbar: Toolbar


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_terminosy_condiciones)


        toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)
        supportActionBar!!.title = resources.getString(R.string.app_name)

        btnAceptarTerminos=findViewById(R.id.btn_aceptarTerminos)
        btnAceptarTerminos.setOnClickListener {

            val intentLogin= Intent(this,MainActivity::class.java)
            startActivity(intentLogin)
            finish()
        }

    }
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == R.id.list_item1) {
            // Realizar Acción aquí
            return true
        }
        return super.onOptionsItemSelected(item)
    }




}