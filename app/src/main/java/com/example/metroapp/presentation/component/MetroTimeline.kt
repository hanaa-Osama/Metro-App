package com.example.metroapp.presentation.component

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.metroapp.domain.model.MetroLine
import com.example.metroapp.ui.theme.Line1Red
import com.example.metroapp.ui.theme.Line2Green
import com.example.metroapp.ui.theme.Line3Blue
import com.example.metroapp.ui.theme.LineYellow
import domain.model.Station

@Composable
fun MetroTimeline(
    stations: List<Station>,
    fromStation: String,
    toStation: String,
    fare: Int,
    totalTime: String,
    totalStations: Int,
    lineChanges: Int,
    modifier: Modifier = Modifier
) {
    Surface(
        modifier = modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.background
    ) {
        Column(
            modifier = Modifier.padding(16.dp)
        ) {
            RouteSummaryCard(
                fromStation = fromStation,
                toStation = toStation,
                fare = fare,
                totalTime = totalTime,
                totalStations = totalStations,
                lineChanges = lineChanges
            )

            Spacer(modifier = Modifier.height(24.dp))

            LazyColumn(
                modifier = Modifier.weight(1f)
            ) {
                itemsIndexed(stations) { index, station ->
                    val previousStation = stations.getOrNull(index - 1)
                    // Avoiding duplicates if the data has them (common in transfer points)
                    if (previousStation?.name != station.name) {
                        MetroStationItem(
                            station = station,
                            lineColor = getLineColor(station.line),
                            isFirst = index == 0,
                            isLast = index == stations.size - 1
                        )
                    }
                }
            }
        }
    }
}

fun getLineColor(line: MetroLine): Color {
    return when (line) {
        MetroLine.LINE_1 -> Line1Red
        MetroLine.LINE_2 -> Line2Green
        MetroLine.LINE_3 -> Line3Blue
        MetroLine.YELLOW -> LineYellow
    }
}