package com.example.bookshelf.data

import com.example.bookshelf.model.BookItem
import com.example.bookshelf.network.BookshelfApiService
import com.example.bookshelf.network.model.GetBookItemsListResponse

interface BookShelfRepository {
    suspend fun getBookItems(query:String):GetBookItemsListResponse

    suspend fun getBookItemInfo(query:String):List<BookItem>
}

class DefaultBookShelfRepository(
    private val bookshelfApiService: BookshelfApiService
):BookShelfRepository {
    override suspend fun getBookItems(query:String): GetBookItemsListResponse = bookshelfApiService.getBookItemsList(query)

    override suspend fun getBookItemInfo(query:String): List<BookItem> {
        val bookItems = getBookItems(query).items

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