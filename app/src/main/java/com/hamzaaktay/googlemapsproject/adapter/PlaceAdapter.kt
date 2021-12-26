package com.hamzaaktay.googlemapsproject.adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.constraintlayout.widget.Placeholder
import androidx.recyclerview.widget.RecyclerView
import com.hamzaaktay.googlemapsproject.databinding.RecyclerRowBinding
import com.hamzaaktay.googlemapsproject.model.Place
import com.hamzaaktay.googlemapsproject.view.MainActivity
import com.hamzaaktay.googlemapsproject.view.MapsActivity

class PlaceAdapter (val placeList : List<Place>): RecyclerView.Adapter <PlaceAdapter.PlaceHolder>() {


    class PlaceHolder (val recylerRowBinding: RecyclerRowBinding): RecyclerView.ViewHolder(recylerRowBinding.root) {


    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PlaceHolder {
        val recylerRowBinding = RecyclerRowBinding.inflate(LayoutInflater.from(parent.context), parent,false)
        return PlaceHolder(recylerRowBinding)
    }

    override fun onBindViewHolder(holder: PlaceHolder, position: Int) {
        holder.recylerRowBinding.recyclerViewTextView.text = placeList.get(position).name
        holder.itemView.setOnClickListener {
            val intent = Intent(holder.itemView.context, MapsActivity::class.java)
            intent.putExtra("selectedPlace", placeList.get(position))
            intent.putExtra("info","old")
            holder.itemView.context.startActivity(intent)
        }
    }

    override fun getItemCount(): Int {
        return placeList.size
    }


}