package com.example.tarea05_constraintlayout

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
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

        val txtUsuario = findViewById<EditText>(R.id.user)
        val txtPass = findViewById<EditText>(R.id.passW)
        val btnLogin = findViewById<Button>(R.id.botonLogin)
        val txtPrueba = findViewById<TextView>(R.id.textoPrueba)

        btnLogin.setOnClickListener {
            val user = txtUsuario.text.toString()
            val pass = txtPass.text.toString()
            val resultado = "Usuario: "+txtUsuario.text+"\nContrasinal: "+txtPass.text;
            txtPrueba.text = resultado
        }
    }
}