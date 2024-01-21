package com.example.bookshelf.ui.screen

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun MainScreen(
    modifier:Modifier = Modifier
) {
    
}

@Composable
fun LoadingScreen(
    modifier: Modifier = Modifier
) {

}


@Composable
fun ErrorScreen(
    modifier: Modifier = Modifier
) {

}


@Composable
fun SuccessScreen(
    modifier: Modifier = Modifier
) {

}

@Preview(showBackground = true)
@Composable
fun LoadingScreenPreview() {
    LoadingScreen()
}

@Preview(showBackground = true)
@Composable
fun ErrorScreenPreview() {
    LoadingScreen()
}

@Preview(showBackground = true)
@Composable
fun SuccessScreenPreview() {
    LoadingScreen()
}