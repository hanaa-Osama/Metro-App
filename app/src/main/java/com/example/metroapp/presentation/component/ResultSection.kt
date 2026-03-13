package com.example.metroapp.presentation.component

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import domain.model.RouteResult


@Composable
fun ResultSection(result: RouteResult.Success, modifier: Modifier = Modifier) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(top = 20.dp)
    ) {
        Text("Stations: ${result.stations.distinctBy { it.name }.size}")
        Text("Time: ${result.time} min")
        Text("Fare: ${result.fare} EGP")
        Spacer(modifier = Modifier.height(20.dp))
        RouteStationList(result)
    }
}