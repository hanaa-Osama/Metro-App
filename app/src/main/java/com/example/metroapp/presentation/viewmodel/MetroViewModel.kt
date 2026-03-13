package com.example.metroapp.presentation.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.example.metroapp.domain.use_case.GetAllStationsUseCase
import domain.model.RouteResult
import domain.model.Station
import domain.usecases.FindRouteUseCase
import domain.usecases.GetDirectionUseCase

class MetroViewModel(
    private val findRoute : FindRouteUseCase,
    private val getDirection : GetDirectionUseCase,
    private val getStations: GetAllStationsUseCase
) : ViewModel(){



    var startStation by mutableStateOf("")
    var endStation by mutableStateOf("")
    var result by mutableStateOf<RouteResult?>(null)

    var stations by mutableStateOf<List<Station>>(emptyList())
    init {
        stations = getStations()
    }
    fun calculateRoute(){
        result = findRoute(startStation, endStation)
    }
}