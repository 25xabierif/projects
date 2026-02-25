package com.example.exame

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import com.example.exame.databinding.FragmentSummaryBinding

class SummaryFragment : Fragment() {

    private var _binding: FragmentSummaryBinding? = null
    private val binding: FragmentSummaryBinding
        get() = _binding!!

    private val gastoViewModel : GastoViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentSummaryBinding.inflate(inflater, container, false)
        val view = binding.root
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        gastoViewModel.gastoTotal.observe(viewLifecycleOwner) {
            binding.textTotal.text = "Total: $it €"
        }
        binding.fab.setOnClickListener {
            gastoViewModel.gastoCero()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}