package com.dapascript.foodipedia.data.source.model

import com.squareup.moshi.Json

data class DetailResponse(

    @Json(name = "meals")
    val meals: List<DetailFood?>? = null
)

data class DetailFood(

    @Json(name = "strImageSource")
    val strImageSource: Any? = null,

    @Json(name = "strIngredient10")
    val strIngredient10: String? = null,

    @Json(name = "strIngredient12")
    val strIngredient12: String? = null,

    @Json(name = "strIngredient11")
    val strIngredient11: String? = null,

    @Json(name = "strIngredient14")
    val strIngredient14: String? = null,

    @Json(name = "strCategory")
    val strCategory: String? = null,

    @Json(name = "strIngredient13")
    val strIngredient13: String? = null,

    @Json(name = "strIngredient16")
    val strIngredient16: String? = null,

    @Json(name = "strIngredient15")
    val strIngredient15: String? = null,

    @Json(name = "strIngredient18")
    val strIngredient18: String? = null,

    @Json(name = "strIngredient17")
    val strIngredient17: String? = null,

    @Json(name = "strArea")
    val strArea: String? = null,

    @Json(name = "strCreativeCommonsConfirmed")
    val strCreativeCommonsConfirmed: Any? = null,

    @Json(name = "strIngredient19")
    val strIngredient19: String? = null,

    @Json(name = "strTags")
    val strTags: String? = null,

    @Json(name = "idMeal")
    val idMeal: String? = null,

    @Json(name = "strInstructions")
    val strInstructions: String? = null,

    @Json(name = "strIngredient1")
    val strIngredient1: String? = null,

    @Json(name = "strIngredient3")
    val strIngredient3: String? = null,

    @Json(name = "strIngredient2")
    val strIngredient2: String? = null,

    @Json(name = "strIngredient20")
    val strIngredient20: String? = null,

    @Json(name = "strIngredient5")
    val strIngredient5: String? = null,

    @Json(name = "strIngredient4")
    val strIngredient4: String? = null,

    @Json(name = "strIngredient7")
    val strIngredient7: String? = null,

    @Json(name = "strIngredient6")
    val strIngredient6: String? = null,

    @Json(name = "strIngredient9")
    val strIngredient9: String? = null,

    @Json(name = "strIngredient8")
    val strIngredient8: String? = null,

    @Json(name = "strMealThumb")
    val strMealThumb: String? = null,

    @Json(name = "strMeasure20")
    val strMeasure20: String? = null,

    @Json(name = "strYoutube")
    val strYoutube: String? = null,

    @Json(name = "strMeal")
    val strMeal: String? = null,

    @Json(name = "strMeasure12")
    val strMeasure12: String? = null,

    @Json(name = "strMeasure13")
    val strMeasure13: String? = null,

    @Json(name = "strMeasure10")
    val strMeasure10: String? = null,

    @Json(name = "strMeasure11")
    val strMeasure11: String? = null,

    @Json(name = "dateModified")
    val dateModified: Any? = null,

    @Json(name = "strDrinkAlternate")
    val strDrinkAlternate: Any? = null,

    @Json(name = "strSource")
    val strSource: String? = null,

    @Json(name = "strMeasure9")
    val strMeasure9: String? = null,

    @Json(name = "strMeasure7")
    val strMeasure7: String? = null,

    @Json(name = "strMeasure8")
    val strMeasure8: String? = null,

    @Json(name = "strMeasure5")
    val strMeasure5: String? = null,

    @Json(name = "strMeasure6")
    val strMeasure6: String? = null,

    @Json(name = "strMeasure3")
    val strMeasure3: String? = null,

    @Json(name = "strMeasure4")
    val strMeasure4: String? = null,

    @Json(name = "strMeasure1")
    val strMeasure1: String? = null,

    @Json(name = "strMeasure18")
    val strMeasure18: String? = null,

    @Json(name = "strMeasure2")
    val strMeasure2: String? = null,

    @Json(name = "strMeasure19")
    val strMeasure19: String? = null,

    @Json(name = "strMeasure16")
    val strMeasure16: String? = null,

    @Json(name = "strMeasure17")
    val strMeasure17: String? = null,

    @Json(name = "strMeasure14")
    val strMeasure14: String? = null,

    @Json(name = "strMeasure15")
    val strMeasure15: String? = null
) {
    fun getIngredient(i: Int): String? {
        return when (i) {
            1 -> strIngredient1 ?: ""
            2 -> strIngredient2 ?: ""
            3 -> strIngredient3 ?: ""
            4 -> strIngredient4 ?: ""
            5 -> strIngredient5 ?: ""
            6 -> strIngredient6 ?: ""
            7 -> strIngredient7 ?: ""
            8 -> strIngredient8 ?: ""
            9 -> strIngredient9 ?: ""
            10 -> strIngredient10 ?: ""
            11 -> strIngredient11 ?: ""
            12 -> strIngredient12 ?: ""
            13 -> strIngredient13 ?: ""
            14 -> strIngredient14 ?: ""
            15 -> strIngredient15 ?: ""
            16 -> strIngredient16 ?: ""
            17 -> strIngredient17 ?: ""
            18 -> strIngredient18 ?: ""
            19 -> strIngredient19 ?: ""
            20 -> strIngredient20 ?: ""
            else -> ""
        }
    }

    fun getMeasure(i: Int): String? {
        return when (i) {
            1 -> strMeasure1 ?: ""
            2 -> strMeasure2 ?: ""
            3 -> strMeasure3 ?: ""
            4 -> strMeasure4 ?: ""
            5 -> strMeasure5 ?: ""
            6 -> strMeasure6 ?: ""
            7 -> strMeasure7 ?: ""
            8 -> strMeasure8 ?: ""
            9 -> strMeasure9 ?: ""
            10 -> strMeasure10 ?: ""
            11 -> strMeasure11 ?: ""
            12 -> strMeasure12 ?: ""
            13 -> strMeasure13 ?: ""
            14 -> strMeasure14 ?: ""
            15 -> strMeasure15 ?: ""
            16 -> strMeasure16 ?: ""
            17 -> strMeasure17 ?: ""
            18 -> strMeasure18 ?: ""
            19 -> strMeasure19 ?: ""
            20 -> strMeasure20 ?: ""
            else -> ""
        }
    }
}
