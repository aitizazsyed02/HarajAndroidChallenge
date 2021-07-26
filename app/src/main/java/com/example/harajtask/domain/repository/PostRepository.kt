package com.example.harajtask.domain.repository

import com.example.harajtask.data.model.GetPostsResponseItem

interface PostRepository {

    suspend fun getPosts(): List<GetPostsResponseItem>?
}