package com.example.barbershop.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.barbershop.databinding.ServicesItemBinding
import com.example.barbershop.model.Services

class ServicesAdapter(private val context: Context, private val listServices: MutableList<Services>):
    RecyclerView.Adapter<ServicesAdapter.ServicesViewHolder>() {

    inner class ServicesViewHolder(binding: ServicesItemBinding): RecyclerView.ViewHolder(binding.root) {
        val imageService = binding.imageService
        val serviceDescription = binding.txtServiceDescription
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ServicesViewHolder {
        val itemList = ServicesItemBinding.inflate(LayoutInflater.from(context), parent, false)
        return ServicesViewHolder(itemList)
    }

    override fun getItemCount() = listServices.size

    override fun onBindViewHolder(holder: ServicesViewHolder, position: Int) {
        holder.imageService.setImageResource(listServices[position].image!!)
        holder.serviceDescription.text = listServices[position].name
    }
}