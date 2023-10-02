package com.dapascript.foodipedia.data.repository

import com.dapascript.foodipedia.data.source.model.CategoriesItem
import com.dapascript.foodipedia.data.source.network.ApiService
import com.dapascript.foodipedia.utils.Resource
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class FoodRepositoryImpl @Inject constructor(
    private val apiService: ApiService,
    private val ioDispatcher: CoroutineDispatcher
) : FoodRepository {

    override fun getCategories(): Flow<Resource<List<CategoriesItem?>?>> = flow {
        emit(Resource.Loading)

        try {
            val response = apiService.getCategories().categories
            emit(Resource.Success(response))
        } catch (e: Exception) {
            emit(Resource.Error(e.message.toString()))
        }
    }.flowOn(ioDispatcher)
}

interface FoodRepository {

    fun getCategories(): Flow<Resource<List<CategoriesItem?>?>>
}