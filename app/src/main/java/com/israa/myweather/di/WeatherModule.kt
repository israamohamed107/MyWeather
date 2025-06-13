package com.israa.myweather.di

import com.google.android.gms.location.FusedLocationProviderClient
import com.google.android.gms.location.LocationServices
import com.israa.myweather.data.LocationDataSource
import com.israa.myweather.data.remote.datasource.WeatherDataSource
import com.israa.myweather.data.remote.datasource.WeatherDataSourceImpl
import com.israa.myweather.data.repository.WeatherRepositoryImpl
import com.israa.myweather.domain.repository.WeatherRepository
import com.israa.myweather.ui.weather.WeatherViewModel
import io.ktor.client.HttpClient
import io.ktor.client.engine.cio.CIO
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module
import org.koin.androidx.viewmodel.dsl.viewModelOf


val weatherModule = module {
    single {
        HttpClient(CIO) {
            install(ContentNegotiation) {
                json(Json {
                    prettyPrint = true
                    isLenient = true
                    ignoreUnknownKeys = true
                })

            }

        }

    }

    single<WeatherDataSource> {
        WeatherDataSourceImpl(
            client = get()
        )
    }

    single<LocationDataSource> {
        LocationDataSource(
            context = get(),
            fusedLocationProviderClient = get()
        )
    }

    single<FusedLocationProviderClient> {
        LocationServices.getFusedLocationProviderClient(androidContext())
    }

    single<WeatherRepository> {
        WeatherRepositoryImpl(
            weatherDataSource = get(),
            locationDataSource = get(),
            context = androidContext()
        )
    }
    viewModelOf(::WeatherViewModel)


}