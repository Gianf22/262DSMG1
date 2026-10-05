package com.example.limaexplore.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

enum class CategoryType {
    PARQUES,
    RESTAURANTES,
    CAFETERIAS
}

data class Category(
    val type: CategoryType,
    @StringRes val titleRes: Int,
    @DrawableRes val iconRes: Int
)

data class Place(
    val id: Long,
    val category: CategoryType,
    @StringRes val nameRes: Int,
    @StringRes val descriptionRes: Int,
    @DrawableRes val imageRes: Int
)
