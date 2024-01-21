package com.example.bookshelf.ui.screen

sealed interface BookshelfUiState{

    data class Success(val item: String): BookshelfUiState

    object Error:BookshelfUiState

    object Loading:BookshelfUiState
}