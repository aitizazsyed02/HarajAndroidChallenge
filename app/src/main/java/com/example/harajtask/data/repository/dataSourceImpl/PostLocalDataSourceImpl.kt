package com.example.harajtask.data.repository.dataSourceImpl

import com.example.harajtask.data.model.GetPostsResponse
import com.example.harajtask.data.model.GetPostsResponseItem
import com.example.harajtask.data.repository.dataSource.PostLocalDataSource
import com.google.gson.Gson
import java.io.IOException

class PostLocalDataSourceImpl(
    private val jsonString: String
) : PostLocalDataSource {

    override suspend fun getPostsFromAssets(): List<GetPostsResponseItem>? {
        return try {
            Gson().fromJson(jsonString, GetPostsResponse::class.java).toList()
        } catch (e: IOException) {
            null
        }
    }
}