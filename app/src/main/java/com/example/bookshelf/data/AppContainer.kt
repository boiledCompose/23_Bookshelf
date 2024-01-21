package com.example.bookshelf.data

import com.example.bookshelf.network.BookshelfApiService
import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import retrofit2.Retrofit

interface AppContainer {
    val bookShelfRepository: BookShelfRepository
}

class DefaultAppContainer() : AppContainer {

    private  val baseUrl = "https://www.googleapis.com/books/v1/"

    private val json = Json { ignoreUnknownKeys = true }

    val retrofit = Retrofit.Builder()
        .addConverterFactory(json.asConverterFactory("appication/json".toMediaType()))
        .baseUrl(baseUrl)
        .build()

    val retrofitService: BookshelfApiService by lazy {
        retrofit.create(BookshelfApiService::class.java)
    }

    override val bookShelfRepository: BookShelfRepository by lazy {
        DefaultBookShelfRepository(retrofitService)
    }
}