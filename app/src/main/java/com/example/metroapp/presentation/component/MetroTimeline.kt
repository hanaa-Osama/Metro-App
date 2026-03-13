package com.example.metroapp.presentation.component

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.metroapp.domain.model.MetroLine
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
    Column(
        modifier = modifier.padding(top=25.dp)
    ) {
        Row(
            modifier = Modifier.padding(horizontal = 16.dp)
        ) {
            RouteSummaryCard(
                fromStation = fromStation,
                toStation = toStation,
                fare = fare,
                totalTime = totalTime,
                totalStations = totalStations,
                lineChanges = lineChanges
            )
        }
        Column(
            modifier = Modifier.padding(26.dp)
        ) {
            LazyColumn {
                itemsIndexed(stations) { index, station ->
                    val previousStation = stations.getOrNull(index-1)
                    if (previousStation?.name != station.name){
                        MetroStationItem(
                            station = station,
                            lineColor = getLineColor(station.line),
                            isLast = station == stations.last()
                        )
                    }

                }
            }
        }

    }
}
fun getLineColor(line: MetroLine): Color {
    return when (line) {
        MetroLine.LINE_1 -> Color(0xFF8E0B0B)
        MetroLine.LINE_2 -> Color.Green
        MetroLine.LINE_3 -> Color.Blue
        MetroLine.YELLOW -> Color.Yellow
    }
}