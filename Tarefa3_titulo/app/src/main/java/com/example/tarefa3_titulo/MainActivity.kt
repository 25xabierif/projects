package com.example.tarefa3_titulo

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AlertDialog
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

        val text1 = findViewById<EditText>(R.id.campo1)
        val text2 = findViewById<EditText>(R.id.campo2)
        val button = findViewById<Button>(R.id.boton)
        button.setOnClickListener{
            val nombre = text1.text.toString()
            val comentario = text2.text.toString()
            val mensaje = "Nome: $nombre\nComentario: $comentario"

            AlertDialog.Builder(this)
                .setTitle("Proba de comentario")
                .setMessage(mensaje)
                .setPositiveButton("Aceptar", null)
                .show()
        }
    }
}