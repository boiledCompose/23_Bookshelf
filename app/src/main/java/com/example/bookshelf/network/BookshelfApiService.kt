package com.example.bookshelf.network

import com.example.bookshelf.network.model.GetBookImageUrlResponse
import com.example.bookshelf.network.model.GetBookItemsListResponse
import retrofit2.http.GET
import retrofit2.http.Path

interface BookshelfApiService {
    @GET("volumes?q=jazz+history")
    suspend fun getBookItemsList():GetBookItemsListResponse
    @GET("volumes/{volume_id}")
    suspend fun getBookImageUrl(@Path("volume_id") volumeId:String):GetBookImageUrlResponse
}



