package com.dapascript.foodipedia.presentation.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.dapascript.foodipedia.data.repository.FoodRepository
import com.dapascript.foodipedia.data.source.model.CategoriesItem
import com.dapascript.foodipedia.utils.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CategoriesViewModel @Inject constructor(
    private val foodRepository: FoodRepository
) : ViewModel() {

    private val _getFoodCategories = MutableLiveData<Resource<List<CategoriesItem?>?>>()
    val getFoodCategories: LiveData<Resource<List<CategoriesItem?>?>> = _getFoodCategories

    init {
        viewModelScope.launch {
            foodRepository.getCategories().collect {
                _getFoodCategories.value = it
            }
        }
    }
}