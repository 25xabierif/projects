package com.example.fragmentosnavegacion

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.navigation.findNavController

class SecondFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_second, container, false)
        val texto = view.findViewById<TextView>(R.id.sec_textview).text

        val buttonNext = view.findViewById<Button>(R.id.second_button)
        buttonNext.setOnClickListener {
            view.findNavController().navigate(SecondFragmentDirections.actionSecondFragmentToFinalFragment(texto.toString()))
        }

        return view
    }
}