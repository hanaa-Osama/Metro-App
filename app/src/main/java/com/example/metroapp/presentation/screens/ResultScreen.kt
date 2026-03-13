package com.example.metroapp.presentation.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.metroapp.presentation.component.MetroTimeline
import com.example.metroapp.presentation.component.WhenError
import com.example.metroapp.presentation.viewmodel.MetroViewModel
import domain.model.RouteResult

@Composable
fun ResultScreen(viewModel: MetroViewModel) {
    val result = viewModel.result

    when (result) {
        is RouteResult.Success -> {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(top = 20.dp)
            ) {
                MetroTimeline(
                    stations = result.stations,
                    fromStation = result.fromStation,
                    toStation = result.toStation,
                    fare = result.fare,
                    totalTime = result.time,
                    totalStations = result.stations.size,
                    lineChanges = result.lineChanges
                )
                Spacer(modifier = Modifier.height(16.dp))
            }
        }
        is RouteResult.Error -> {
            WhenError(result)
        }
        null -> {
            Column(
                modifier = Modifier.fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                Card(
                    shape = RoundedCornerShape(20.dp)
                ) {
                    Text(
                        text = "Enter Stations To Calculate Route",
                        modifier = Modifier.padding(24.dp),
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Bold
                    )
                }
            }
        }
    }
}