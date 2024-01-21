package com.example.bookshelf.data

import com.example.bookshelf.model.BookItem
import com.example.bookshelf.network.BookshelfApiService
import com.example.bookshelf.network.model.GetBookItemsListResponse

interface BookShelfRepository {
    suspend fun getBookItems():GetBookItemsListResponse

    suspend fun getBookItemInfo():List<BookItem>
}

class DefaultBookShelfRepository(
    private val bookshelfApiService: BookshelfApiService
):BookShelfRepository {
    override suspend fun getBookItems(): GetBookItemsListResponse = bookshelfApiService.getBookItemsList()

    override suspend fun getBookItemInfo(): List<BookItem> {
        val bookItems = getBookItems().items

        val bookItemList = mutableListOf<BookItem>()
        for(item in bookItems) {
            val result = bookshelfApiService.getBookImageUrl(item.id)
            bookItemList.apply {
                add(BookItem(result.volumeInfo.title, result.volumeInfo.imageLinks.thumbnail))
            }
        }

        return bookItemList.toList()
    }
}