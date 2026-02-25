package com.example.exame

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.example.exame.databinding.FragmentAddBinding
import kotlin.getValue

class AddFragment : Fragment() {

    private var _binding: FragmentAddBinding? = null
    private val binding: FragmentAddBinding
        get() = _binding!!

    private val gastoViewModel : GastoViewModel by activityViewModels()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentAddBinding.inflate(inflater, container, false)
        val view = binding.root
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.btnGardar.setOnClickListener {
            val gastoTexto = binding.editCantidade.text.toString()
            val gasto = gastoTexto.toDoubleOrNull() ?: 0.0

            if(gasto > 0){
                gastoViewModel.addGasto(gasto)
            }
            findNavController().popBackStack()
        }
    }

    override fun onDestroyView(){
        super.onDestroyView()
        _binding = null
    }
}