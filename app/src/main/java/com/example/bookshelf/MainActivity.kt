package com.example.bookshelf

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.bookshelf.ui.BookShelfApp
import com.example.bookshelf.ui.screen.BookshelfViewModel
import com.example.bookshelf.ui.theme.BookshelfTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BookshelfTheme {

                val bookshelfViewModel:BookshelfViewModel = viewModel(factory = BookshelfViewModel.Factory)
                BookShelfApp(bookshelfViewModel.bookshelfUiState)
            }
        }
    }
}