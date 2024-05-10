package com.example.restaurante

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.restaurante.databinding.ActivityPedidoBinding

class PedidoActivity : AppCompatActivity() {
    private lateinit var binding: ActivityPedidoBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        // Inflando o layout usando ViewBinding
        binding = ActivityPedidoBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        // Obtendo os dados da intent
        val i = intent
        val quantidadePizza = i.getStringExtra("quantidadePizza").toString().toInt()
        val quantidadeSalada = i.getStringExtra("quantidadeSalada").toString().toInt()
        val quantidadeHamburguer = i.getStringExtra("quantidadeHamburguer").toString().toInt()

        // Criando o texto de resumo do pedido com base nos dados recebidos
        val texto = "Resumo do Pedido\n" +
                "Pizza: $quantidadePizza Preço: ${quantidadePizza * 8}\n" +
                "Salada: $quantidadeSalada Preço: ${quantidadeSalada * 10}\n" +
                "Hamburguer: $quantidadeHamburguer Preço: ${quantidadeHamburguer * 12}\n"

        // Exibindo o resumo do pedido no TextView
        binding.textResumo.text = texto

    }
}