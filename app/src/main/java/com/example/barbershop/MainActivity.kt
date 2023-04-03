package com.example.barbershop

import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.activity.result.contract.ActivityResultContracts
import com.example.barbershop.databinding.ActivityMainBinding
import com.example.barbershop.view.Home
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding =  ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar?.hide()

        binding.btLogin.setOnClickListener {
            val name = binding.editNameLogin.text.toString()
            val password = binding.editPasswordLogin.text.toString()

            when {
                name.isEmpty() -> {
                    messageAlert(it, "Coloque o seu nome!")
                } password.isEmpty() -> {
                    messageAlert(it, "Preencha a senha!")
                } password.toString().trim().length < 6 -> {
                    messageAlert(it, "A senha precisa ter pelo menos 6 caracteres!")
                } else -> {
                    navigateToHomeScreen(name)
                }
            }
        }
    }

    private fun messageAlert(view: View, messageText: String) {
        val snackbar = Snackbar.make(view, messageText, Snackbar.LENGTH_SHORT)
        snackbar.setBackgroundTint(Color.parseColor("#FF0000"))
        snackbar.setTextColor(Color.parseColor("#FFFFFF"))
        snackbar.show()
    }

    private fun navigateToHomeScreen(name: String) {
        val intent = Intent(this, Home::class.java)
        intent.putExtra("name", name)
        startActivity(intent)
    }
}