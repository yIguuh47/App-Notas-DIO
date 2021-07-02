package com.example.projetonotasdio

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btCalcular = findViewById<Button>(R.id.bt_start)
        val tvMedia = findViewById<TextView>(R.id.tv_media)
        val tvFaltas = findViewById<TextView>(R.id.tv_faltas)

        btCalcular.setOnClickListener {

            val nota1 = (et_nota1.text.toString()).toDouble()
            val nota2 = (et_nota2.text.toString()).toDouble()
            val faltas = (et_faltas.text.toString()).toInt()

            var media = calculo(nota1,nota2)

            tvFaltas.setText("Faltas: $faltas")
            tvMedia.setText("Média: %.2f".format(media))

            if (media >= 7 && faltas <= 12) {
                Toast.makeText(applicationContext, "Aluno Aprovado!", Toast.LENGTH_SHORT).show()
                tvFaltas.setTextColor(Color.GREEN)
                tv_media.setTextColor(Color.GREEN)
            } else {
                Toast.makeText(applicationContext, "Aluno reprovado!", Toast.LENGTH_SHORT).show()
                tvFaltas.setTextColor(Color.RED)
                tv_media.setTextColor(Color.RED)
            }
        }
    }

    fun calculo(nota1: Double, nota2: Double) = (nota1 + nota2) / 2

}

