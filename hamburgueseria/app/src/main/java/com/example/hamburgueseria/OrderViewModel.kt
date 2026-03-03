package com.example.hamburgueseria

import androidx.lifecycle.*
import androidx.lifecycle.ViewModel

class OrderViewModel: ViewModel() {
    private val _total = MutableLiveData<Double>()
    val total: LiveData<Double> get() = _total

    private val _name = MutableLiveData<String>()
    val name: LiveData<String> get() = _name

    fun addOrder(price: Double, userName: String){
        _total.value = (_total.value?:0.0) + price
        _name.value = userName
    }

    fun clear() {
        _total.value = 0.0
        _name.value = ""
    }

}