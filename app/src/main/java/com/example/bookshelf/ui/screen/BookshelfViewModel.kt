package com.example.bookshelf.ui.screen

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProvider.AndroidViewModelFactory.Companion.APPLICATION_KEY
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.example.bookshelf.BookshelfApplication
import com.example.bookshelf.data.BookShelfRepository
import com.example.bookshelf.model.BookItem
import kotlinx.coroutines.launch
import retrofit2.HttpException
import java.io.IOException

sealed interface BookshelfUiState{
    data class Success(
        val bookItems: List<BookItem>
    ): BookshelfUiState

    object Error:BookshelfUiState

    object Loading:BookshelfUiState
}

class BookshelfViewModel(
    private val bookShelfRepository: BookShelfRepository,
    private val query: String
): ViewModel() {
    var bookshelfUiState: BookshelfUiState by mutableStateOf(BookshelfUiState.Loading)

    init {
        getBookImageUrlsByQuery()
    }

    fun getBookImageUrlsByQuery() {
        viewModelScope.launch {
            bookshelfUiState = try {
                val bookItemList = bookShelfRepository.getBookItemInfo(query)
                BookshelfUiState.Success(bookItemList)
            } catch (e:HttpException){
                BookshelfUiState.Error
            } catch (e:IOException) {
                BookshelfUiState.Error
            }
        }
    }

    companion object {
        var query:String = "jazz+history"

        val Factory: ViewModelProvider.Factory = viewModelFactory {
            initializer {
                val application = (this[APPLICATION_KEY] as BookshelfApplication)
                val bookShelfRepository = application.container.bookShelfRepository
                BookshelfViewModel(bookShelfRepository = bookShelfRepository, query=query)
            }
        }
    }
}

