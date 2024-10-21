package com.example.proyecto4

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import android.content.Intent
import android.view.LayoutInflater
import android.widget.Toast
import com.example.proyecto4.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    //Declaramos la variable binding
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        //Inicializar el Binding
        binding=ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        //Configuramos
        binding.btnLogin.setOnClickListener {
            val username = binding.etUsername.text.toString().trim()
            val password = binding.etPassword.text.toString().trim()
            if (username.isEmpty() || password.isEmpty()){
                Toast.makeText(this, "Por favor, llena todos los campos", Toast.LENGTH_LONG).show()
            } else if(password != "1234"){
                    Toast.makeText(this, "Contraseña incorrecta, intente de nuevo", Toast.LENGTH_LONG).show()
            } else {
                //Logica de autenticacion
                val intent = Intent(this, SecondActivity::class.java) //Ir de un activity a otro
                intent.putExtra("username", username)
                startActivity(intent)
            }
        }
    }
}