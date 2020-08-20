package com.hr.navviewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MyViewModel:ViewModel() {

    private val _numberLiveData:MutableLiveData<Int> = MutableLiveData<Int>().also{
        it.value = 0
    }
    var numberLiveData = _numberLiveData



    fun add(x:Int){
        _numberLiveData?.value = _numberLiveData?.value?.plus(x)
        if (_numberLiveData?.value!! <= 0){
            _numberLiveData!!.value = 0
        }

    }



}