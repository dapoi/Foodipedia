package com.dapascript.foodipedia.data.source.model

import com.squareup.moshi.Json

data class CategoriesResponse(

    @Json(name = "categories")
    val categories: List<CategoriesItem?>? = null
)

data class CategoriesItem(

    @Json(name = "idCategory")
    val idCategory: String? = null,

    @Json(name = "strCategory")
    val strCategory: String? = null,

    @Json(name = "strCategoryThumb")
    val strCategoryThumb: String? = null
)
