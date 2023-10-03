package com.dapascript.foodipedia.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SplashScreenViewModel @Inject constructor() : ViewModel() {

    private val _splashScreenFinished = MutableStateFlow(true)
    val splashScreenFinished = _splashScreenFinished.asStateFlow()

    init {
        viewModelScope.launch {
            delay(2000)
            _splashScreenFinished.value = false
        }
    }
}