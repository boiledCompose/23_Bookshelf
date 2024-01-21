package com.example.bookshelf.ui

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import com.example.bookshelf.R
import com.example.bookshelf.ui.screen.MainScreen


/**
 * MainActivity에서 호출되는 앱 관리 컴포저블
 * MainActivity에서 UI와 데이터 레이어를 분리하기 위해 App 파일을 따로 생성했다.
 */

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BookShelfApp(
    modifier:Modifier = Modifier
) {
    Scaffold(
        topBar ={ BookShelfTopAppBar(modifier) },
        modifier = modifier.fillMaxSize()
    ) {
        Surface(
            modifier = modifier.padding(it)
        ) {
            MainScreen(modifier)
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BookShelfTopAppBar(
    modifier: Modifier = Modifier
) {
    CenterAlignedTopAppBar(
        title = { Text(stringResource(id = R.string.app_name))}
    )
}