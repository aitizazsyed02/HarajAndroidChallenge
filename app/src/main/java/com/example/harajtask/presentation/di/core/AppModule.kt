package com.example.harajtask.presentation.di.core

import android.content.Context
import com.example.harajtask.presentation.di.base.BaseSubComponent
import dagger.Module
import dagger.Provides
import javax.inject.Singleton


@Module(
    subcomponents = [
        BaseSubComponent::class
    ]
)
class AppModule(
    private val context: Context
) {

    @Singleton
    @Provides
    fun providesApplicationContext(): Context {
        return context.applicationContext
    }
}