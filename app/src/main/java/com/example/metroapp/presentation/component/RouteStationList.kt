package com.example.metroapp.presentation.component

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import domain.model.RouteResult


@Composable
fun RouteStationList(result: RouteResult.Success, modifier: Modifier = Modifier) {
    LazyColumn {
        items(result.stations) { station ->
            Text(
                text = "• ${station.name} (${station.line})",
                modifier = Modifier.padding(6.dp)
            )
        }
    }
}