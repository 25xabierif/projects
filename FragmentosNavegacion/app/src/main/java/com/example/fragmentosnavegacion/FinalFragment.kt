package com.example.fragmentosnavegacion

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView

class FinalFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val message = FinalFragmentArgs.fromBundle(requireArguments()).texto


        val view = inflater.inflate(R.layout.fragment_final, container, false)

        view.findViewById<TextView>(R.id.final_text).text = message

        return view
    }
}