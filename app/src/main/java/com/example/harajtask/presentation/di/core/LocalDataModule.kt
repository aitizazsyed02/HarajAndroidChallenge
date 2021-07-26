package com.example.harajtask.presentation.di.core

import com.example.harajtask.data.repository.dataSource.PostLocalDataSource
import com.example.harajtask.data.repository.dataSourceImpl.PostLocalDataSourceImpl
import dagger.Module
import dagger.Provides
import java.io.InputStream
import javax.inject.Singleton

@Module
class LocalDataModule(
    private val jsonString: String
) {
    @Singleton
    @Provides
    fun providesPostLocalDataSource(): PostLocalDataSource {
        return PostLocalDataSourceImpl(jsonString)
    }
}