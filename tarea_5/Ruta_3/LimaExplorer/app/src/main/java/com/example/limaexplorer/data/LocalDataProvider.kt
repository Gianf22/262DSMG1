package com.example.limaexplorer.data

import androidx.compose.material3.R.string
import com.example.limaexplore.model.Category
import com.example.limaexplore.model.CategoryType
import com.example.limaexplore.model.Place
import com.example.limaexplorer.R

object LocalDataProvider {
    val categories = listOf(
        Category(CategoryType.PARQUES, R.string.cat_parques, R.drawable.parque),
        Category(CategoryType.RESTAURANTES, R.string.cat_restaurantes, R.drawable.restaurante),
        Category(CategoryType.CAFETERIAS, R.string.cat_cafeterias, R.drawable.cafeteria)
    )

    val defaultPlace = Place(
        id = 1L,
        category = CategoryType.PARQUES,
        nameRes = R.string.place_parque_amor,
        descriptionRes = R.string.desc_parque_amor,
        imageRes = R.drawable.parque_del_amor
    )

    val places = listOf(
        defaultPlace,
        Place(
            id = 2L,
            category = CategoryType.PARQUES,
            nameRes = R.string.place_olivar,
            descriptionRes = R.string.desc_olivar,
            imageRes = R.drawable.bosque_el_olivar
        ),
        Place(
            id = 3L,
            category = CategoryType.RESTAURANTES,
            nameRes = R.string.place_isolina,
            descriptionRes = R.string.desc_isolina,
            imageRes = R.drawable.isolina_taberna
        ),
        Place(
            id = 4L,
            category = CategoryType.RESTAURANTES,
            nameRes = R.string.place_punto_azul,
            descriptionRes = R.string.desc_punto_azul,
            imageRes = R.drawable.punto_azul
        ),
        Place(
            id = 5L,
            category = CategoryType.CAFETERIAS,
            nameRes = R.string.place_manolo,
            descriptionRes = R.string.desc_manolo,
            imageRes = R.drawable.manolo
        )
    )
}