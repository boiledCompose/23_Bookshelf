package com.example.bookshelf.ui.navigation

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.bookshelf.ui.screen.BookshelfScreen
import com.example.bookshelf.ui.screen.BookshelfViewModel
import com.example.bookshelf.ui.screen.SearchScreen
import com.example.bookshelf.ui.screen.SearchViewModel

enum class AppScreen() {
    Search,
    Result
}

@Composable
fun BookshelfNavHost(
    navController:NavHostController,
    modifier: Modifier = Modifier,
    paddingValues: PaddingValues,
    searchViewModel: SearchViewModel = viewModel()
) {
    NavHost(
        navController = navController,
        startDestination = AppScreen.Search.name,
        modifier = modifier.padding(paddingValues)) {

        composable(route = AppScreen.Search.name){
            SearchScreen(
                searchViewModel = searchViewModel,
                onClick = {
                    navController.navigate(
                        AppScreen.Result.name
                    )
                }
            )
        }

        composable(route = AppScreen.Result.name){
            BookshelfViewModel.query = searchViewModel.searchString.collectAsState().value
            val bookshelfViewModel:BookshelfViewModel = viewModel(
               factory = BookshelfViewModel.Factory
            )

            BookshelfScreen(
                bookshelfViewModel.bookshelfUiState
            )
        }
    }
}