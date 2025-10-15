package com.example.tarefa2_titulo

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        var infoLeoncio = arrayOf("Dato sobre leoncio","Outro dato sobre Leoncio","Mais datos sobre leoncio")
        var infoTigre = arrayOf("Tigre de bengala", "Hai tigres albinos","Os tigres comen principalmente sandía")


        val topImg = findViewById<ImageView>(R.id.topImg)
        topImg.setOnClickListener {
            val valor = infoLeoncio.random()
            val topText = findViewById<TextView>(R.id.textTopImg)
            topText.text = valor
        }

        val tiger = findViewById<ImageView>(R.id.tigre)
        tiger.setOnClickListener {
            val valor = infoTigre.random()
            val tigerText = findViewById<TextView>(R.id.textTigre)
            tigerText.text = valor
        }

    }
}