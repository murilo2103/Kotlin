package com.example.restaurante

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.example.restaurante.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        // Inflando o layout usando ViewBinding
        binding = ActivityMainBinding.inflate(layoutInflater)

        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        // Recuperando o nome de usuário dos extras da intent e exibindo uma saudação se disponível
        val username = intent.extras?.getString("username")
        if (!username.isNullOrEmpty()) {
            binding.textOla.setText("Olá $username")
        }

        // Listener de clique no botão para fechar a atividade
        binding.buttonFechar.setOnClickListener {
            finishAffinity()
        }

        // Listener de clique no botão para navegar para a SplashActivity com os detalhes do pedido
        binding.buttonPedir.setOnClickListener {
            val i = Intent(this, SplashActivity::class.java)
            i.putExtra("quantidadePizza", binding.editQuantidadePizza.text.toString())
            i.putExtra("quantidadeSalada", binding.editQuantidadeSalada.text.toString())
            i.putExtra("quantidadeHamburguer", binding.editQuantidadeHamburguer.text.toString())
            startActivity(i)
            finish()
        }

        // Listener de clique na caixa de seleção de Pizza
        binding.checkPizza.setOnClickListener {
            if (binding.checkPizza.isChecked()) {
                binding.editQuantidadePizza.setText("1")
                binding.textPrecoPizza.visibility = View.VISIBLE
            } else {
                binding.editQuantidadePizza.setText("0")
                binding.textPrecoPizza.visibility = View.GONE
            }
        }

        // Listener de clique na caixa de seleção de Salada
        binding.checkSalada.setOnClickListener {
            if (binding.checkSalada.isChecked()) {
                binding.editQuantidadeSalada.setText("1")
                binding.textPrecoSalada.visibility = View.VISIBLE
            } else {
                binding.editQuantidadeSalada.setText("0")
                binding.textPrecoSalada.visibility = View.GONE
            }
        }

        // Listener de clique na caixa de seleção de Hambúrguer
        binding.checkHamburger.setOnClickListener {
            if (binding.checkHamburger.isChecked()) {
                binding.editQuantidadeHamburguer.setText("1")
                binding.textPrecoHamburguer.visibility = View.VISIBLE
            } else {
                binding.editQuantidadeHamburguer.setText("0")
                binding.textPrecoHamburguer.visibility = View.GONE
            }
        }

    }
}