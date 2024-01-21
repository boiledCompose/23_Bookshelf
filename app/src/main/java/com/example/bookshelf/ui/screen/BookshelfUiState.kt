package com.example.bookshelf.ui.screen

import com.example.bookshelf.model.BookItem

sealed interface BookshelfUiState{

    data class Success(val bookItems: List<BookItem>): BookshelfUiState

    object Error:BookshelfUiState

    object Loading:BookshelfUiState
}