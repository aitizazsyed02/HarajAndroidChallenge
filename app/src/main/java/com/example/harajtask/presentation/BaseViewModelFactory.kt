package com.example.harajtask.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.harajtask.domain.useCase.GetPostsUseCase

class BaseViewModelFactory(
    private val getPostsUseCase: GetPostsUseCase
) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return BaseViewModel(getPostsUseCase) as T
    }
}