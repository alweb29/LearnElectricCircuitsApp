package com.example.alweb29.learnelectriccircuitsapp

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewmodel.viewModelFactory
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

class MainViewModel: ViewModel() {

    //TODO implement some preparation in this file. Remove delay
    private val _isLoading = MutableStateFlow(true)
    val isLoading = _isLoading.asStateFlow()

    init {

        //delay to see splash screen
        viewModelFactory {
            for (i in 0..3000){
                Log.e("msg", i.toString())
        }
            _isLoading.value = false
        }
    }
}