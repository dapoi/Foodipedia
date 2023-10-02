package com.dapascript.foodipedia.data.source.network

import com.dapascript.foodipedia.data.source.model.CategoriesResponse
import com.dapascript.foodipedia.data.source.model.DetailResponse
import com.dapascript.foodipedia.data.source.model.FoodResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    @GET("categories.php")
    suspend fun getCategories(): CategoriesResponse

    @GET("filter.php?")
    suspend fun getMealsByCategory(@Query("c") category: String): FoodResponse

    @GET("lookup.php?")
    suspend fun getMealById(@Query("i") id: String): DetailResponse
}