package com.example.first_app

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.imageview.ShapeableImageView

class SpotAdapter(private val spotList: ArrayList<Spots>) : RecyclerView.Adapter<SpotAdapter.SpotViewHolder>() {
    var onItemClick: ((Spots) -> Unit)? = null
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SpotViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.card_item, parent, false)
        return SpotViewHolder(itemView)
    }


    override fun onBindViewHolder(holder: SpotAdapter.SpotViewHolder, position: Int) {
        val currentItem = spotList[position]
        holder.cardImage.setImageResource(currentItem.cardImage)
        holder.cardTitle.text = currentItem.cardTitle
        holder.cardBody.text = currentItem.cardBody
        holder.cardDistance.text = currentItem.cardDistance

        holder.itemView.setOnClickListener{
            onItemClick?.invoke(currentItem)
        }
    }

    override fun getItemCount(): Int {
        return spotList.size
    }

    class SpotViewHolder(itemView : View): RecyclerView.ViewHolder(itemView) {
        val cardImage: ShapeableImageView = itemView.findViewById(R.id.card_image)
        val cardTitle: TextView = itemView.findViewById(R.id.card_title)
        val cardBody: TextView = itemView.findViewById(R.id.card_body)
        val cardDistance: TextView = itemView.findViewById(R.id.card_distance)
    }

}