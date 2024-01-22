package com.example.bookshelf.ui.screen

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

class SearchViewModel: ViewModel() {

    private val _searchString = MutableStateFlow("")

    val searchString = _searchString.asStateFlow()

    fun setSearchString(string: String) {
        _searchString.value = string
    }

}