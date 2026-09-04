package com.example.calculadoraimc

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import java.util.Locale

class ResultActivity : AppCompatActivity() {

    private lateinit var textImcValor: TextView
    private lateinit var textImcClassificacao: TextView
    private lateinit var btnVoltar: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        textImcValor = findViewById(R.id.textImcValor)
        textImcClassificacao = findViewById(R.id.textImcClassificacao)
        btnVoltar = findViewById(R.id.btnVoltar)

        val peso = intent.getDoubleExtra("peso", 0.0)
        val altura = intent.getDoubleExtra("altura", 0.0)

        val imc = peso / (altura * altura)

        textImcValor.text = String.format(Locale.getDefault(), "IMC: %.2f", imc)
        textImcClassificacao.text = classificarImc(imc)

        btnVoltar.setOnClickListener { finish() }
    }

    private fun classificarImc(imc: Double): String {
        return when {
            imc < 18.5 -> "Você está abaixo do peso"
            imc < 25 -> "Você está com peso ideal"
            imc < 30 -> "Você está com sobrepeso"
            else -> "Você está com obesidade"
        }
    }
}