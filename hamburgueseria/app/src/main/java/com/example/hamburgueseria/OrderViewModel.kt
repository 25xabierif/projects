package com.example.hamburgueseria

import androidx.lifecycle.*
import androidx.lifecycle.ViewModel

class OrderViewModel: ViewModel() {
    private val _total = MutableLiveData<Double>()
    val total: LiveData<Double> get() = _total

    fun addOrder(price: Double){
        _total.value = (_total.value?:0.0) + price
    }

    fun clear() {
        _total.value = 0.0
    }

}