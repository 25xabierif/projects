package com.example.hamburgueseria

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.findNavController
import com.example.hamburgueseria.databinding.FragmentPedidoBinding
import com.google.android.material.snackbar.Snackbar

class PedidoFragment : Fragment() {


    private var _binding: FragmentPedidoBinding?= null
    private val binding get() = _binding!!

    val model: OrderViewModel by viewModels ( ownerProducer = {this.requireActivity()})

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentPedidoBinding.inflate(inflater,container,false)
        val view = binding.root
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.buttonAdd.setOnClickListener {
            val name = binding.userName.text.toString()
            when (binding.burgerChip.checkedChipId) {
                R.id.completa -> total += 7
                R.id.vegana -> total += 6
                R.id.ovo -> total += 7.5
            }
            when (binding.drinkChip.checkedChipId) {
                R.id.auga -> total += 1.5
                R.id.refresco -> total += 2
            }
            model.addOrder(total)
            Snackbar.make(binding.root,"Pedido engadido!", Snackbar.LENGTH_SHORT).show()
            view.findNavController().navigate(
                directions = PedidoFragmentDirections.actionPedidoFragmentToResumoFragment(
                    name
                )
            )
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}