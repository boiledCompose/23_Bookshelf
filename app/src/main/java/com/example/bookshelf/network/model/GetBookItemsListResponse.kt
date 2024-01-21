package com.example.bookshelf.network.model

import kotlinx.serialization.Serializable
@Serializable
data class GetBookItemsListResponse(
    val items: List<GetItemsId>
)

@Serializable
data class GetItemsId (
    val id: String
)
