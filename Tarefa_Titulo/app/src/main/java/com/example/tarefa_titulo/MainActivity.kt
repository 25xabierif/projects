package com.example.tarefa_titulo

import android.os.Bundle
import android.widget.Button
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

        var introduccion = arrayOf("A odisea de","Biografia de","O descanso de")
        var nucleo = arrayOf("Aseguranceturix","don Lambón","Rodrigo")
        var terminar = arrayOf("na Illa de Mann","no Pico Sacro","na praza da Quintana")

        val btnFind = findViewById<Button>(R.id.botonXerar)
        btnFind.setOnClickListener {
            val titulo = (introduccion.random() + " " + nucleo.random() + " " + terminar.random())
            val campoTexto = findViewById<TextView>(R.id.xerarTexto)
            campoTexto.text = titulo
        }
    }
}

/**/