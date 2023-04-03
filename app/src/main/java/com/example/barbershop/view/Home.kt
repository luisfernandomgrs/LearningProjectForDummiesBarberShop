package com.example.barbershop.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import com.example.barbershop.R
import com.example.barbershop.adapter.ServicesAdapter
import com.example.barbershop.databinding.ActivityHomeBinding
import com.example.barbershop.model.Services

class Home : AppCompatActivity() {
    private lateinit var binding: ActivityHomeBinding
    private lateinit var servicesAdapter: ServicesAdapter
    private val listServices: MutableList<Services> = mutableListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar?.hide()
        val name = intent.extras?.getString("name")

        binding.txtUserName.text = "Bem vindo, $name"

        val recyclerViewServices = binding.recyclerViewServices
        recyclerViewServices.layoutManager = GridLayoutManager(this, 2)
        servicesAdapter = ServicesAdapter(this, listServices)
        recyclerViewServices.setHasFixedSize(true)
        recyclerViewServices.adapter = servicesAdapter

        getServices()

        binding.btSchedule.setOnClickListener {
            val intent = Intent(this, ScheduleActivity::class.java)
            intent.putExtra("name", name)
            startActivity(intent)
        }
    }

    private fun getServices() {
        val serviceOne = Services(R.drawable.img1, "Corte de cabelo")
        listServices.add(serviceOne)

        val serviceTwo = Services(R.drawable.img2, "Corte de barba")
        listServices.add(serviceTwo)

        val serviceThree = Services(R.drawable.img3, "Lavagem de cabelo")
        listServices.add(serviceThree)

        val serviceFour = Services(R.drawable.img4, "Tratamento de cabelo")
        listServices.add(serviceFour)
    }
}