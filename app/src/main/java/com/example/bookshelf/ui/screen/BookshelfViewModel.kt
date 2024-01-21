package com.example.bookshelf.ui.screen

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.bookshelf.network.BookApi
import kotlinx.coroutines.launch
import retrofit2.HttpException
import java.io.IOException

private const val TAG = "BookshelfViewModel"
class BookshelfViewModel: ViewModel() {
    var bookshelfUiState: BookshelfUiState by mutableStateOf(BookshelfUiState.Loading)

    init {
        getBookImageUrls()
    }

    private fun getBookImageUrls() {
        viewModelScope.launch {
            bookshelfUiState = try {
                val bookItemList = BookApi.retrofitService.getBookItemsList()
                val imageUrlList = mutableListOf<String>()
                for (item in bookItemList.items) {
                    val result = BookApi.retrofitService.getBookImageUrl(item.id)
                    imageUrlList.apply {
                        add(result.volumeInfo.imageLinks.thumbnail)
                    }
                }
                BookshelfUiState.Success(imageUrlList.toList())
            } catch (e:HttpException){
                BookshelfUiState.Error
            } catch (e:IOException) {
                BookshelfUiState.Error
            }
        }
    }

}