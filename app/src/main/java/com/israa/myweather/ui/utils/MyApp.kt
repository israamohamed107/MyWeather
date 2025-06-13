package com.israa.myweather.ui.utils

import android.app.Application
import com.israa.myweather.di.weatherModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class MyApp : Application() {
    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(this@MyApp)
            modules(weatherModule)
        }
    }
}