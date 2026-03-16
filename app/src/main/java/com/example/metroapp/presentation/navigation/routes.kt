package com.example.metroapp.presentation.navigation

import kotlinx.serialization.Serializable

@Serializable
object HomeRoute


@Serializable
data class ResultRoute(
    val startStation: String,
    val endStation: String,
)