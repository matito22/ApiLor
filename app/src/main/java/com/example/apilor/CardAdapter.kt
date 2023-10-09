package com.example.apilor

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class CardAdapter(val cardItems: MutableList<CardItem>,var context: Context,private val cardItemClickListener: CardItemClickListener) :
    RecyclerView.Adapter<CardAdapter.CardViewHolder>() {

    class CardViewHolder(itemView: View):RecyclerView.ViewHolder(itemView) {
        val cardImage: ImageView = itemView.findViewById(R.id.cardImage)
        val cardTitle: TextView = itemView.findViewById(R.id.cardTitle)
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.activity_card_item ,parent,false)
        return CardViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: CardViewHolder, position: Int) {
        val currentItem = cardItems[position]

        holder.cardImage.setImageResource(currentItem.imageResource)
        holder.cardTitle.text = currentItem.title

        holder.itemView.setOnClickListener {
            // Acción cuando se hace clic en la tarjeta
            // Por ejemplo, abrir una nueva pantalla
            cardItemClickListener.onCardItemClick(currentItem)
        }
    }

    override fun getItemCount() = cardItems.size

    fun setData(newData: List<CardItem>) {
        cardItems.clear()
        cardItems.addAll(newData)
        notifyDataSetChanged()
    }

}

