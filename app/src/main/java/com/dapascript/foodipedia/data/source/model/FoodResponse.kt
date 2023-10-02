package com.dapascript.foodipedia.data.source.model

import com.squareup.moshi.Json

data class FoodResponse(

    @Json(name = "meals")
    val meals: List<ListFood?>? = null
)

data class ListFood(

    @Json(name = "strMealThumb")
    val strMealThumb: String? = null,

    @Json(name = "idMeal")
    val idMeal: String? = null,

    @Json(name = "strMeal")
    val strMeal: String? = null
)
