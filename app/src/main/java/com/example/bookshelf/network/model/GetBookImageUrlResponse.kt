package com.example.bookshelf.network.model

import kotlinx.serialization.Serializable

@Serializable
data class GetBookImageUrlResponse(
    val volumeInfo: GetImageLinks
)

@Serializable
data class GetImageLinks(
    val title:String,
    val imageLinks: GetThumbnail
)

@Serializable
data class GetThumbnail(
    val thumbnail: String
)