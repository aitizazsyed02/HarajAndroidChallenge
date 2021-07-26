package com.example.harajtask.data.repository

import com.example.harajtask.data.model.GetPostsResponseItem
import com.example.harajtask.data.repository.dataSource.PostLocalDataSource
import com.example.harajtask.domain.repository.PostRepository

class PostRepositoryImpl(
    private val localDataSource: PostLocalDataSource
) : PostRepository {

    override suspend fun getPosts(): List<GetPostsResponseItem>? {
        return localDataSource.getPostsFromAssets()
    }
}