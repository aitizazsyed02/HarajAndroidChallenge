package com.example.harajtask.presentation.di.base

import com.example.harajtask.domain.useCase.GetPostsUseCase
import com.example.harajtask.presentation.BaseViewModelFactory
import dagger.Module
import dagger.Provides

@Module
class BaseModule {

    @BaseScope
    @Provides
    fun providesBaseViewModelFactory(
        getPostsUseCase: GetPostsUseCase
    ):BaseViewModelFactory{
        return BaseViewModelFactory(
            getPostsUseCase
        )
    }
}