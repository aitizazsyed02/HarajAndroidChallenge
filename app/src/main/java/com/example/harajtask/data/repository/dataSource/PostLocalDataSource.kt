package com.example.harajtask.data.repository.dataSource

import com.example.harajtask.data.model.GetPostsResponse

interface PostLocalDataSource {

    suspend fun getPostsFromAssets(): List<GetPostsResponse>
}