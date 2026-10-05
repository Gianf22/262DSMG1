package com.example.bookshelf

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.bookshelf.ui.theme.BookshelfTheme
import com.example.bookshelf.userinterface.BooksViewModel
import com.example.bookshelf.userinterface.HomeScreen

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            BookshelfTheme {
                // Mantenemos el Scaffold para respetar los márgenes del sistema
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->

                    // 1. Instanciamos el ViewModel usando el Factory que creamos en los pasos anteriores
                    val booksViewModel: BooksViewModel = viewModel(factory = BooksViewModel.Factory)

                    // 2. Llamamos a nuestra interfaz real (HomeScreen) y le pasamos los datos
                    HomeScreen(
                        booksUiState = booksViewModel.booksUiState,
                        retryAction = { booksViewModel.getBooks("jazz history") },
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}