package com.example.lockin

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class AdapterClass(var dataList : ArrayList<DataClass>) : RecyclerView.Adapter<AdapterClass.ViewHolderClass>(){



    class ViewHolderClass(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var rvImage: ImageView = itemView.findViewById(R.id.recyclerImage)
        var rvTitle: TextView = itemView.findViewById(R.id.recyclerTitle)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolderClass {
        var itemView = LayoutInflater.from(parent.context).inflate(R.layout.item_layout, parent, false)
        return ViewHolderClass(itemView)
    }

    override fun onBindViewHolder(holder: ViewHolderClass, position: Int) {
        var currentItems = dataList[position]
        holder.rvImage.setImageResource(currentItems.dataImage)
        holder.rvTitle.text = currentItems.dataTitle
    }


    override fun getItemCount(): Int {
        return dataList.size
    }
}

