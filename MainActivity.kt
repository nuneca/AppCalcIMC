package com.example.calculadoraimc

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private lateinit var editPeso: EditText
    private lateinit var editAltura: EditText
    private lateinit var btnCalcular: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        editPeso = findViewById(R.id.editPeso)
        editAltura = findViewById(R.id.editAltura)
        btnCalcular = findViewById(R.id.btnCalcular)

        btnCalcular.setOnClickListener { calcularImc() }
    }

    private fun calcularImc() {
        val pesoStr = editPeso.text.toString().trim()
        val alturaStr = editAltura.text.toString().trim()

        if (pesoStr.isEmpty() || alturaStr.isEmpty()) {
            Toast.makeText(this, "Preencha peso e altura", Toast.LENGTH_SHORT).show()
            return
        }

        val peso = pesoStr.toDoubleOrNull()
        val altura = alturaStr.toDoubleOrNull()

        if (peso == null || altura == null) {
            Toast.makeText(this, "Digite valores numéricos válidos", Toast.LENGTH_SHORT).show()
            return
        }

        if (peso <= 0 || altura <= 0) {
            Toast.makeText(this, "Valores devem ser maiores que zero", Toast.LENGTH_SHORT).show()
            return
        }

        val intent = Intent(this, ResultActivity::class.java).apply {
            putExtra("peso", peso)
            putExtra("altura", altura)
        }
        startActivity(intent)
    }
}