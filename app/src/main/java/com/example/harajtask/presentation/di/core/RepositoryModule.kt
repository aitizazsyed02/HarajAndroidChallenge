package com.example.harajtask.presentation.di.core

import com.example.harajtask.data.repository.PostRepositoryImpl
import com.example.harajtask.data.repository.dataSource.PostLocalDataSource
import com.example.harajtask.domain.repository.PostRepository
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class RepositoryModule {

    @Singleton
    @Provides
    fun providesPostRepository(
        localDataSource: PostLocalDataSource
    ): PostRepository {
        return PostRepositoryImpl(
            localDataSource
        )
    }
}