package com.example.bookshelf.ui.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.bookshelf.R

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
    Column(
    ) {
        Image(
            painter = painterResource(id = R.drawable.ic_connection_error),
            contentDescription = "",
            modifier = Modifier
        )

        Text(
            text = "Checking Internet Connection"
        )
    }
}


@Composable
fun SuccessScreen(
    modifier: Modifier = Modifier
) {

}

@Preview(showBackground = true)
@Composable
fun LoadingScreenPreview() {
    SuccessScreen()
}

@Preview(showBackground = true)
@Composable
fun ErrorScreenPreview() {
    ErrorScreen()
}

@Preview(showBackground = true)
@Composable
fun SuccessScreenPreview() {
    LoadingScreen()
}