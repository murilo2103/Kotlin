package com.example.restaurante

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.restaurante.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity() {
//Criação da variável binding que servirá para manipular a tela.
    private lateinit var binding:ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Infla o layout da tela de login usando o binding.
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)
        // Configura o listener para o botão "Entrar".
        binding.buttonEntrar.setOnClickListener {
            val username = binding.editUsername.text.toString().trim()
            val password = binding.editPassword.text.toString().trim()
            // Verifica se o usuário e a senha correspondem aos valores esperados.
            if (username.equals("Enzo") && password.equals("7")) {
                val i = Intent(this, MainActivity::class.java)
                i.putExtra("username", username)
                startActivity(i)
                finish()
            } else {
                // Caso contrário, exibe uma mensagem de erro.
                Toast.makeText(applicationContext, "Errou", Toast.LENGTH_LONG).show()
            }
        }

    }
}