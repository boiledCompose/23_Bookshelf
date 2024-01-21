package com.example.bookshelf.network

import com.example.bookshelf.network.model.GetBookImageUrlResponse
import com.example.bookshelf.network.model.GetBookItemsListResponse
import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import retrofit2.Retrofit
import retrofit2.http.GET
import retrofit2.http.Path

private const val BASE_URL = "https://www.googleapis.com/books/v1/"

interface BookshelfApiService {
    @GET("volumes?q=jazz+history")
    suspend fun getBookItemsList():GetBookItemsListResponse
    @GET("volumes/{volume_id}")
    suspend fun getBookImageUrl(@Path("volume_id") volumeId:String):GetBookImageUrlResponse
}

private val json = Json { ignoreUnknownKeys = true }

val retrofit = Retrofit.Builder()
    .addConverterFactory(json.asConverterFactory("appication/json".toMediaType()))
    .baseUrl(BASE_URL)
    .build()

object BookApi {
    val retrofitService: BookshelfApiService by lazy {
        retrofit.create(BookshelfApiService::class.java)
    }
}