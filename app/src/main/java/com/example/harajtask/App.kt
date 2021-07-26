package com.example.harajtask

import android.app.Application
import androidx.appcompat.app.AppCompatDelegate
import com.example.harajtask.presentation.di.Injector
import com.example.harajtask.presentation.di.base.BaseSubComponent
import com.example.harajtask.presentation.di.core.AppComponent
import com.example.harajtask.presentation.di.core.AppModule
import com.example.harajtask.presentation.di.core.DaggerAppComponent
import com.example.harajtask.presentation.di.core.LocalDataModule
import com.example.harajtask.presentation.util.Files
import com.example.harajtask.presentation.util.readFile

class App : Application(), Injector {
    companion object {
        private const val TAG: String = "App"
        lateinit var instance: App
    }

    private lateinit var appComponent: AppComponent

    override fun onCreate() {
        super.onCreate()

        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_FOLLOW_SYSTEM)
        instance = this

        appComponent= DaggerAppComponent.builder()
            .appModule(AppModule(applicationContext))
            .localDataModule(
                LocalDataModule(
                    baseContext.assets.readFile(Files.dataFile)
                )
            )
            .build()

    }

    override fun createBaseSubComponent(): BaseSubComponent {
        return appComponent.baseSubComponent().create()
    }

}