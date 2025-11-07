package com.example.halloween

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.example.halloween.R

class StoryFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_story, container, false)
    }

    private val args:StoryFragmentArgs by navArgs()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val textTheme = view.findViewById<TextView>(R.id.text_theme)
        val imageStory = view.findViewById<ImageView>(R.id.image_story)
        val textShow = view.findViewById<TextView>(R.id.text_show)
        val button = view.findViewById<Button>(R.id.button_volver)

        val theme = args.themeSelected

        textTheme.text = theme

        val imageRes = when (theme){
            "Casa encantada" -> R.drawable.haunted_house
            "Bosque" -> R.drawable.haunted_forest
            "Aquelarre de bruxas" -> R.drawable.witch_coven
            else -> R.drawable.halloween

        }
        imageStory.setImageResource(imageRes)
        textShow.text = story

        button.setOnClickListener{
            findNavController().navigate(R.id.action_StoryFragment_to_nameFragment)
        }
    }