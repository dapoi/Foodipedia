package com.dapascript.foodipedia.data.source.network

import com.dapascript.foodipedia.data.source.model.CategoriesResponse
import retrofit2.http.GET

interface ApiService {

    @GET("categories.php")
    suspend fun getCategories(): CategoriesResponse
}