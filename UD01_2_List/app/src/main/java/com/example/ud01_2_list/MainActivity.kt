package com.example.ud01_2_list

import android.os.Bundle
import android.widget.Button
import android.widget.Spinner
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

        val btnFind = findViewById<Button>(R.id.findBtn)
        btnFind.setOnClickListener {
            val spinner = findViewById<Spinner>(R.id.animal_type)
            val animalList = findViewById<TextView>(R.id.animal_list)

            animalList.text = getAnimalList(spinner.selectedItemId).joinToString("\n")
        }
    }

    fun getAnimalList(id: Long) : List<String> = when(id){
        0L -> listOf("Siamés", "Gato pelado", "Gato laranxa")
        1L -> listOf("Chihuaua", "Yorkie", "Min tzu")
        2L -> listOf("Paxariño", "Tucán", "Periquito")
        else -> listOf()
    }
}