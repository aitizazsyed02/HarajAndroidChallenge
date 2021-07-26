package com.example.harajtask.presentation.di.core

import com.example.harajtask.domain.repository.PostRepository
import com.example.harajtask.domain.useCase.GetPostsUseCase
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class UseCaseModule {

    @Singleton
    @Provides
    fun providesGetPostsUseCase(
        repository: PostRepository
    ): GetPostsUseCase {
        return GetPostsUseCase(
            repository
        )
    }
}