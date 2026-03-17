package com.example.metroapp.presentation.screens.stateUI

import domain.model.RouteResult
import domain.model.Station

data class UIState(
    val startStation: String = "",
    val endStation: String = "",
    val stations: List<Station> = emptyList(),
    val result: RouteResult? = null
)
