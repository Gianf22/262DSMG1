package com.example.limaexplorer.ui.theme

import androidx.activity.compose.BackHandler
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FilterChip
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.windowsizeclass.WindowWidthSizeClass
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.limaexplorer.R
import com.example.limaexplore.model.Category
import com.example.limaexplore.model.Place
import com.example.limaexplore.utils.LimaContentType

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LimaExploreApp(
    windowSize: WindowWidthSizeClass,
    onBackPressed: () -> Unit,
    modifier: Modifier = Modifier,
    viewModel: LimaExploreViewModel = viewModel()
) {
    val uiState by viewModel.uiState.collectAsState()

    val contentType = when (windowSize) {
        WindowWidthSizeClass.Expanded -> LimaContentType.ListAndDetail
        else -> LimaContentType.ListOnly
    }

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        text = if (!uiState.isShowingListPage && contentType == LimaContentType.ListOnly) {
                            stringResource(uiState.currentSelectedPlace.nameRes)
                        } else {
                            stringResource(R.string.app_name)
                        }
                    )
                },
                navigationIcon = {
                    if (!uiState.isShowingListPage && contentType == LimaContentType.ListOnly) {
                        IconButton(onClick = { viewModel.navigateToListPage() }) {
                            Icon(
                                imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                                contentDescription = stringResource(R.string.back_button)
                            )
                        }
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primaryContainer,
                    titleContentColor = MaterialTheme.colorScheme.onPrimaryContainer
                )
            )
        }
    ) { innerPadding ->
        if (contentType == LimaContentType.ListAndDetail) {
            LimaListAndDetail(
                uiState = uiState,
                onCategorySelected = { viewModel.updateSelectedCategory(it.type) },
                onPlaceSelected = { viewModel.updateSelectedPlace(it) },
                modifier = modifier.padding(innerPadding)
            )
        } else {
            if (uiState.isShowingListPage) {
                LimaListScreen(
                    uiState = uiState,
                    onCategorySelected = { viewModel.updateSelectedCategory(it.type) },
                    onPlaceSelected = { viewModel.updateSelectedPlace(it) },
                    modifier = modifier.padding(innerPadding)
                )
            } else {
                BackHandler { viewModel.navigateToListPage() }
                PlaceDetailScreen(
                    place = uiState.currentSelectedPlace,
                    modifier = modifier.padding(innerPadding)
                )
            }
        }
    }
}

@Composable
fun LimaListScreen(
    uiState: LimaExploreUiState,
    onCategorySelected: (Category) -> Unit,
    onPlaceSelected: (Place) -> Unit,
    modifier: Modifier = Modifier
) {
    Column(modifier = modifier.fillMaxSize()) {
        CategorySelector(
            categories = uiState.categories,
            selectedCategory = uiState.selectedCategory,
            onCategorySelected = onCategorySelected,
            modifier = Modifier.padding(16.dp)
        )
        LazyColumn(
            contentPadding = PaddingValues(horizontal = 16.dp, vertical = 8.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            items(uiState.currentCategoryPlaces) { place ->
                PlaceCard(place = place, onPlaceClick = onPlaceSelected)
            }
        }
    }
}

@Composable
fun LimaListAndDetail(
    uiState: LimaExploreUiState,
    onCategorySelected: (Category) -> Unit,
    onPlaceSelected: (Place) -> Unit,
    modifier: Modifier = Modifier
) {
    Row(modifier = modifier.fillMaxSize()) {
        Column(modifier = Modifier.weight(1f)) {
            CategorySelector(
                categories = uiState.categories,
                selectedCategory = uiState.selectedCategory,
                onCategorySelected = onCategorySelected,
                modifier = Modifier.padding(16.dp)
            )
            LazyColumn(
                contentPadding = PaddingValues(horizontal = 16.dp, vertical = 8.dp),
                verticalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                items(uiState.currentCategoryPlaces) { place ->
                    PlaceCard(place = place, onPlaceClick = onPlaceSelected)
                }
            }
        }
        PlaceDetailScreen(
            place = uiState.currentSelectedPlace,
            modifier = Modifier.weight(1f)
        )
    }
}

@Composable
fun CategorySelector(
    categories: List<Category>,
    selectedCategory: com.example.limaexplore.model.CategoryType,
    onCategorySelected: (Category) -> Unit,
    modifier: Modifier = Modifier
) {
    LazyRow(
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        modifier = modifier
    ) {
        items(categories) { category ->
            FilterChip(
                selected = category.type == selectedCategory,
                onClick = { onCategorySelected(category) },
                label = { Text(text = stringResource(category.titleRes)) }
            )
        }
    }
}

@Composable
fun PlaceCard(
    place: Place,
    onPlaceClick: (Place) -> Unit,
    modifier: Modifier = Modifier
) {
    Card(
        modifier = modifier
            .fillMaxWidth()
            .clickable { onPlaceClick(place) },
        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)
    ) {
        Row(
            modifier = Modifier.padding(12.dp)
        ) {
            Image(
                painter = painterResource(place.imageRes),
                contentDescription = null,
                modifier = Modifier.height(72.dp),
                contentScale = ContentScale.Crop
            )
            Column(
                modifier = Modifier
                    .padding(start = 16.dp)
                    .weight(1f)
            ) {
                Text(
                    text = stringResource(place.nameRes),
                    style = MaterialTheme.typography.titleMedium
                )
                Text(
                    text = stringResource(place.descriptionRes),
                    style = MaterialTheme.typography.bodyMedium,
                    maxLines = 2
                )
            }
        }
    }
}

@Composable
fun PlaceDetailScreen(
    place: Place,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .padding(16.dp)
    ) {
        Image(
            painter = painterResource(place.imageRes),
            contentDescription = null,
            modifier = Modifier
                .fillMaxWidth()
                .height(220.dp),
            contentScale = ContentScale.Crop
        )
        Spacer(modifier = Modifier.height(16.dp))
        Text(
            text = stringResource(place.nameRes),
            style = MaterialTheme.typography.headlineSmall
        )
        Spacer(modifier = Modifier.height(8.dp))
        Text(
            text = stringResource(place.descriptionRes),
            style = MaterialTheme.typography.bodyLarge
        )
    }
}