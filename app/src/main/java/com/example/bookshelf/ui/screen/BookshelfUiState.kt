package com.example.bookshelf.ui.screen

sealed interface BookshelfUiState{

    data class Success(val imageUrls: List<String>): BookshelfUiState

    object Error:BookshelfUiState

    object Loading:BookshelfUiState
}