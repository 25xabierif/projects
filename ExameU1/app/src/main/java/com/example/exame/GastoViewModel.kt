package com.example.exame

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class GastoViewModel : ViewModel() {

    private val _total = MutableLiveData(0.0)

    val gastoTotal: LiveData<Double> get() = _total

    fun addGasto(gasto: Double) {
        _total.value = (gastoTotal.value ?: 0.0) + gasto
    }

    fun gastoCero(){
        _total.value = 0.0
    }

}