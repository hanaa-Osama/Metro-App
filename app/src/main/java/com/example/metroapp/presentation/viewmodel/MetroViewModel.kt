package com.example.metroapp.presentation.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.example.metroapp.domain.use_case.GetAllStationsUseCase
import com.example.metroapp.presentation.screens.stateUI.UIState
import domain.model.RouteResult
import domain.model.Station
import domain.usecases.FindRouteUseCase
import domain.usecases.GetDirectionUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

class MetroViewModel(
    private val findRoute : FindRouteUseCase,
    private val getDirection : GetDirectionUseCase,
    private val getStations: GetAllStationsUseCase
) : ViewModel(){


    private val _uiState = MutableStateFlow(UIState())
    val uiState = _uiState.asStateFlow()

    init {
        _uiState.value = _uiState.value.copy(
            stations = getStations()
        )
    }

    fun updateStartStation(station: String) {
        _uiState.value = _uiState.value.copy(startStation = station)
    }

    fun updateEndStation(station: String) {
        _uiState.value = _uiState.value.copy(endStation = station)
    }


    fun calculateRoute() {
        val start = _uiState.value.startStation
        val end = _uiState.value.endStation

        if (start.isBlank() || end.isBlank()) {
            _uiState.value = _uiState.value.copy(
                result = RouteResult.Error("Please select both stations")
            )
            return
        }

        val route = findRoute(start, end)

        _uiState.value = _uiState.value.copy(result = route)
    }
}