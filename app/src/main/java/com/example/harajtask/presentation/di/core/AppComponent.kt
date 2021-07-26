package com.example.harajtask.presentation.di.core

import com.example.harajtask.presentation.di.base.BaseSubComponent
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        AppModule::class,
        LocalDataModule::class,
        RepositoryModule::class,
        UseCaseModule::class
    ]
)
interface AppComponent {
    fun baseSubComponent(): BaseSubComponent.Factory
}