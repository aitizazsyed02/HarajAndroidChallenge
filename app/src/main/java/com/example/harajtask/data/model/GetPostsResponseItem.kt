package com.example.harajtask.data.model

data class GetPostsResponseItem(
    val body: String,
    val city: String,
    val commentCount: Int,
    val date: Int,
    val thumbURL: String,
    val title: String,
    val username: String
)