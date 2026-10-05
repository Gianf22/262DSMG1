package com.example.bookshelf.network

import com.google.gson.annotations.SerializedName

data class QueryResponse(
    @SerializedName("items") val items: List<BookInfo>?
)

data class BookInfo(
    @SerializedName("id") val id: String,
    @SerializedName("volumeInfo") val volumeInfo: VolumeInfo
)

data class VolumeInfo(
    @SerializedName("title") val title: String,
    @SerializedName("imageLinks") val imageLinks: ImageLinks?
)

data class ImageLinks(
    @SerializedName("thumbnail") val thumbnail: String
)

data class Book(
    val id: String,
    val title: String,
    val thumbnailUrl: String
)