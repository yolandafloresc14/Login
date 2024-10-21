package com.example.proyecto4

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import android.content.Intent
import com.example.proyecto4.databinding.ActivityMainBinding
import com.example.proyecto4.databinding.ActivitySecondBinding

class SecondActivity : AppCompatActivity() {

    //Declaramos la variable binding
    private lateinit var binding: ActivitySecondBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //Inicializar el Binding
        binding= ActivitySecondBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //Obtener valor de username
        val username = intent.getStringExtra("username")

        //Mostrar el mensaje de bienvenida
        binding.tvWelcome.text = "Bienvenido $username"

        //Configurar el boton logout
        binding.btnLogout.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
    }
}