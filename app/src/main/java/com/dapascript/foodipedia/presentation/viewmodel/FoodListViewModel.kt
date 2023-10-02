package com.dapascript.foodipedia.presentation.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.dapascript.foodipedia.data.repository.FoodRepository
import com.dapascript.foodipedia.data.source.model.ListFood
import com.dapascript.foodipedia.utils.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class FoodListViewModel @Inject constructor(
    private val foodRepository: FoodRepository,
    savedStateHandle: SavedStateHandle
) : ViewModel() {

    private val _getFood = MutableLiveData<Resource<List<ListFood?>>>()
    val getFood: LiveData<Resource<List<ListFood?>>> = _getFood

    init {
        viewModelScope.launch {
            val id = savedStateHandle.get<String>("nameFood")
            foodRepository.getMealsByCategory(id.toString()).collect {
                _getFood.value = it
            }
        }
    }
}