package com.example.harajtask.presentation.di

import com.example.harajtask.presentation.di.base.BaseSubComponent

interface Injector {
    fun createBaseSubComponent(): BaseSubComponent
}