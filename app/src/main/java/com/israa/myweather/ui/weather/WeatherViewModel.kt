package com.israa.myweather.ui.weather

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.israa.myweather.domain.repository.WeatherRepository
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.flatMapMerge
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class WeatherViewModel(
    private val weatherRepository: WeatherRepository,
): ViewModel(),WeatherInteractionHandler {
    private val _state = MutableStateFlow(WeatherState())
    val state = _state.asStateFlow()

    @OptIn(ExperimentalCoroutinesApi::class)
    override fun getWeather() {
        viewModelScope.launch {
            weatherRepository.getLastKnownLocation()
                .flatMapMerge { location->
                    weatherRepository.getWeather(location.latitude,location.longitude)
                }.collect{response->
                    _state.update {
                        it.copy(weatherData = response)
                    }
                    Log.e("pppedpep", "getWeather: $response", )
                }

        }
    }

}