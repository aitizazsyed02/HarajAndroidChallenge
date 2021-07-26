package com.example.harajtask.presentation.di.base

import com.example.harajtask.presentation.BaseActivity
import dagger.Subcomponent

@BaseScope
@Subcomponent(modules = [BaseModule::class])
interface BaseSubComponent {

    fun inject(baseActivity: BaseActivity)

    @Subcomponent.Factory
    interface Factory {
        fun create(): BaseSubComponent
    }
}