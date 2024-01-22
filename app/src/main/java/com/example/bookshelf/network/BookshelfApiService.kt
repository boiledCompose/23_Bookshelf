package com.example.bookshelf.network

import com.example.bookshelf.network.model.GetBookImageUrlResponse
import com.example.bookshelf.network.model.GetBookItemsListResponse
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface BookshelfApiService {
    @GET("volumes")
    suspend fun getBookItemsList(@Query("q") query:String):GetBookItemsListResponse
    @GET("volumes/{volume_id}")
    suspend fun getBookImageUrl(@Path("volume_id") volumeId:String):GetBookImageUrlResponse
}



