package com.example.bookshelf.userinterface

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProvider.AndroidViewModelFactory.Companion.APPLICATION_KEY
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.example.bookshelf.BooksApplication
import com.example.bookshelf.data.BooksRepository
import com.example.bookshelf.network.Book
import kotlinx.coroutines.launch
import retrofit2.HttpException
import java.io.IOException

sealed interface BooksUiState {
    data class Success(val books: List<Book>) : BooksUiState
    object Error : BooksUiState
    object Loading : BooksUiState
}

class BooksViewModel(private val booksRepository: BooksRepository) : ViewModel() {
    var booksUiState: BooksUiState by mutableStateOf(BooksUiState.Loading)
        private set

    init {
        getBooks("jazz history") // Término de búsqueda por defecto
    }

    fun getBooks(query: String) {
        viewModelScope.launch {
            booksUiState = BooksUiState.Loading
            booksUiState = try {
                val result = booksRepository.getBooks(query)
                BooksUiState.Success(result)
            } catch (e: IOException) {
                // Esto imprimirá el error exacto en el Logcat
                android.util.Log.e("BookshelfApp", "Error de red (IOException): ${e.message}", e)
                BooksUiState.Error
            } catch (e: HttpException) {
                // Esto nos dirá si Google Books rechazó la conexión (ej. Error 403 o 404)
                android.util.Log.e("BookshelfApp", "Error del servidor (HttpException): Código ${e.code()}", e)
                BooksUiState.Error
            } catch (e: Exception) {
                // Atrapa cualquier otro error oculto, como problemas leyendo el JSON
                android.util.Log.e("BookshelfApp", "Error inesperado: ${e.message}", e)
                BooksUiState.Error
            }
        }
    }

    companion object {
        val Factory: ViewModelProvider.Factory = viewModelFactory {
            initializer {
                val application = (this[APPLICATION_KEY] as BooksApplication)
                val booksRepository = application.container.booksRepository
                BooksViewModel(booksRepository = booksRepository)
            }
        }
    }
}