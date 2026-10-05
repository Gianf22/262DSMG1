package com.example.limaexplorer.ui.theme

import com.example.limaexplore.model.Category
import com.example.limaexplore.model.CategoryType
import com.example.limaexplore.model.Place
import com.example.limaexplorer.data.LocalDataProvider

/**
 * Estado inmutable de toda la aplicación.
 */
data class LimaExploreUiState(
    val categories: List<Category> = LocalDataProvider.categories,
    val selectedCategory: CategoryType = CategoryType.PARQUES,
    val currentSelectedPlace: Place = LocalDataProvider.defaultPlace,
    val isShowingListPage: Boolean = true
) {
    val currentCategoryPlaces: List<Place>
        get() = LocalDataProvider.places.filter { it.category == selectedCategory }
}