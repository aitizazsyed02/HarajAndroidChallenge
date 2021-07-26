package com.example.harajtask.data.repository.dataSource

import com.example.harajtask.data.model.GetPostsResponseItem

interface PostLocalDataSource {

    suspend fun getPostsFromAssets(): List<GetPostsResponseItem>?
}