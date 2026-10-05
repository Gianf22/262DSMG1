package com.example.bookshelf.data

import com.example.bookshelf.network.Book
import com.example.bookshelf.network.BooksApiService

interface BooksRepository {
    suspend fun getBooks(query: String): List<Book>
}

class DefaultBooksRepository(
    private val apiService: BooksApiService
) : BooksRepository {

    override suspend fun getBooks(query: String): List<Book> {
        // 1. Una sola petición a la red
        val searchResponse = apiService.searchBooks(query)

        // 2. Mapeamos la respuesta directamente a nuestra lista de la IU
        return searchResponse.items?.mapNotNull { item ->
            // Aseguramos que la URL use HTTPS, requisito de la librería Coil
            val thumbnail = item.volumeInfo.imageLinks?.thumbnail?.replace("http:", "https:")

            // Solo mostramos los libros que sí tienen portada disponible
            if (thumbnail != null) {
                Book(
                    id = item.id,
                    title = item.volumeInfo.title,
                    thumbnailUrl = thumbnail
                )
            } else {
                null
            }
        } ?: emptyList()
    }
}