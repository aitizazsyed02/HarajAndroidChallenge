package com.example.harajtask.domain.useCase

import com.example.harajtask.data.model.GetPostsResponse
import com.example.harajtask.domain.repository.PostRepository

class GetPostsUseCase(
    private val postRepository: PostRepository
) {
    suspend fun execute(): List<GetPostsResponse> = postRepository.getPosts()
}