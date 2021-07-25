package com.example.harajtask.domain.repository

import com.example.harajtask.data.model.GetPostsResponse

interface PostRepository {

    suspend fun getPosts(): List<GetPostsResponse>
}