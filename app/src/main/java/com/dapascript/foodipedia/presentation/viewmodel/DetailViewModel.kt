package com.dapascript.foodipedia.presentation.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.dapascript.foodipedia.data.repository.FoodRepository
import com.dapascript.foodipedia.data.source.model.DetailFood
import com.dapascript.foodipedia.utils.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DetailViewModel @Inject constructor(
    private val foodRepository: FoodRepository,
    savedStateHandle: SavedStateHandle
) : ViewModel() {

    private val _getDetail = MutableLiveData<Resource<List<DetailFood?>>>()
    val getDetail: LiveData<Resource<List<DetailFood?>>> = _getDetail

    init {
        viewModelScope.launch {
            val id = savedStateHandle.get<String>("idDetail")
            foodRepository.getMealsDetailById(id.toString()).collect {
                _getDetail.value = it
            }
        }
    }
}