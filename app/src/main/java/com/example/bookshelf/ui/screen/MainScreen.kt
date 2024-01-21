package com.example.bookshelf.ui.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.example.bookshelf.R
import com.example.bookshelf.model.BookItem

@Composable
fun MainScreen(
    uiState: BookshelfUiState,
    modifier: Modifier = Modifier
) {
        when (uiState) {
            is BookshelfUiState.Success -> SuccessScreen(
                bookItems = uiState.bookItems,
                modifier = modifier
                    .fillMaxSize()
                    .background(Color.White)
            )

            is BookshelfUiState.Loading -> LoadingScreen(
                modifier = modifier
                    .fillMaxSize()
                    .background(Color.White))
            is BookshelfUiState.Error -> ErrorScreen(
                modifier = modifier
                    .fillMaxSize()
                    .background(Color.White))
        }

}

@Composable
fun LoadingScreen(
    modifier: Modifier = Modifier
) {
    Column(
    ) {
        Image(
            painter = painterResource(id = R.drawable.loading_img),
            contentDescription = "",
            modifier = modifier.size(200.dp)
        )
    }
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
            modifier = Modifier.fillMaxWidth()
        )

        Text(
            text = "Checking Internet Connection"
        )
    }
}


@Composable
fun SuccessScreen(
    bookItems: List<BookItem>,
    modifier: Modifier = Modifier
) {
    LazyVerticalGrid(
        columns = GridCells.Fixed(2),
        verticalArrangement = Arrangement.spacedBy(4.dp),
        horizontalArrangement = Arrangement.spacedBy(4.dp),
        modifier = modifier.fillMaxWidth(),
        contentPadding = PaddingValues(4.dp)
    ) {
        items(items = bookItems) {
            item -> BookThumbnailCard(
            bookTitle = item.title,
            imgUrl = item.imgUrl)
        }
    }
}

@Composable
fun BookThumbnailCard(
    bookTitle: String = stringResource(id = R.string.default_image_description),
    imgUrl: String,
    modifier:Modifier = Modifier
) {
    Card(
        modifier = Modifier.height(300.dp),
        shape = RoundedCornerShape(0.dp)
    ) {
        AsyncImage(
            model = ImageRequest.Builder(context = LocalContext.current)
                .data(imgUrl.replace("http", "https"))
                .crossfade(true)
                .build(),
            error = painterResource(id = R.drawable.ic_broken_image),
            placeholder = painterResource(id = R.drawable.loading_img),
            contentDescription = bookTitle,
            contentScale = ContentScale.Crop,
            modifier = Modifier.fillMaxHeight()
        )
    }
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