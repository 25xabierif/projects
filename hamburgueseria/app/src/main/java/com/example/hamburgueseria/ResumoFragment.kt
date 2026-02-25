package com.example.hamburgueseria

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.example.hamburgueseria.databinding.FragmentResumoBinding
import androidx.navigation.fragment.findNavController
import com.example.hamburgueseria.OrderViewModel


class ResumoFragment : Fragment() {

    private var _binding: FragmentResumoBinding? = null
    private val binding get() = _binding!!

    val model: OrderViewModel by viewModels ( ownerProducer = {this.requireActivity()})

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentResumoBinding.inflate(inflater,container,false)
        val view = binding.root
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val args = ResumoFragmentArgs.fromBundle(requireArguments())
        binding.resumoUsername.text = args.username

        model.total.observe(viewLifecycleOwner){
            binding.resumoTotal.text = "Total: $it €"
        }

        binding.limpar.setOnClickListener {
            model.clear()
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}