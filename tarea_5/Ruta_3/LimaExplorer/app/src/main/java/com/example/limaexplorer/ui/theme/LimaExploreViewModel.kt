package com.example.limaexplorer.ui.theme

import androidx.lifecycle.ViewModel
import com.example.limaexplore.model.CategoryType
import com.example.limaexplore.model.Place
import com.example.limaexplorer.data.LocalDataProvider
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class LimaExploreViewModel : ViewModel() {

    private val _uiState = MutableStateFlow(LimaExploreUiState())
    val uiState: StateFlow<LimaExploreUiState> = _uiState.asStateFlow()

    fun updateSelectedCategory(categoryType: CategoryType) {
        _uiState.update { currentState ->
            val firstPlaceInCategory = LocalDataProvider.places.firstOrNull { it.category == categoryType }
                ?: currentState.currentSelectedPlace
            currentState.copy(
                selectedCategory = categoryType,
                currentSelectedPlace = firstPlaceInCategory,
                isShowingListPage = true
            )
        }
    }

    fun updateSelectedPlace(place: Place) {
        _uiState.update { currentState ->
            currentState.copy(
                currentSelectedPlace = place,
                isShowingListPage = false
            )
        }
    }

    fun navigateToListPage() {
        _uiState.update { it.copy(isShowingListPage = true) }
    }
}