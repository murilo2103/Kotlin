package com.example.restaurante

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper

class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        // Usando o Handler para exibir a tela de splash por 2 segundos
        Handler(Looper.getMainLooper()).postDelayed({
            // Obtendo os dados da intent anterior
            val i = intent
            // Criando uma nova intent para a PedidoActivity e passando os dados
            val j = Intent(this, PedidoActivity::class.java)
            j.putExtras(i)
            startActivity(j)
        }, 2000)

    }
}