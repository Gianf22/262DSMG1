package com.example.bookshelf.network

import retrofit2.http.GET
import retrofit2.http.Query

interface BooksApiService {
    @GET("volumes")
    suspend fun searchBooks(
        @Query("q") query: String,
        @Query("key") apiKey: String = "PEGA_AQUI_TU_API_KEY"
    ): QueryResponse
}