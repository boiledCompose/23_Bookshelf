package com.example.bookshelf

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.navigation.compose.rememberNavController
import com.example.bookshelf.ui.navigation.BookshelfNavHost
import com.example.bookshelf.ui.screen.BookshelfViewModel
import com.example.bookshelf.ui.screen.SearchViewModel


/**
 * MainActivity에서 호출되는 앱 관리 컴포저블
 * MainActivity에서 UI와 데이터 레이어를 분리하기 위해 App 파일을 따로 생성했다.
 */

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BookShelfApp(
    modifier:Modifier = Modifier
) {
    val navController = rememberNavController()

    val searchViewModel: SearchViewModel
    val bookshelfViewModel: BookshelfViewModel
    Scaffold(
        topBar ={
            BookShelfTopAppBar(
                canNavigateBack = navController.previousBackStackEntry != null,
                navigateUp = { navController.navigateUp() },
                modifier = Modifier
            ) },
        modifier = modifier.fillMaxSize()
    ) {
        BookshelfNavHost(navController = navController, paddingValues = it)
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BookShelfTopAppBar(
    canNavigateBack:Boolean,
    navigateUp:() -> Unit,
    modifier: Modifier = Modifier
) {
    CenterAlignedTopAppBar(
        title = { Text(stringResource(id = R.string.app_name))},
        navigationIcon = {
            if(canNavigateBack) {
                IconButton(onClick = navigateUp) {
                    Icon(
                        imageVector = Icons.Filled.ArrowBack,
                        contentDescription = null
                    )
                }
            }
        }
    )
}