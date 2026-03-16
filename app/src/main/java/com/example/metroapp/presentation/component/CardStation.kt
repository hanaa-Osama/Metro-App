package com.example.metroapp.presentation.component

import android.R
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.metroapp.presentation.navigation.ResultRoute
import com.example.metroapp.presentation.screens.stateUI.UIState
import com.example.metroapp.presentation.viewmodel.MetroViewModel
import com.example.metroapp.ui.theme.Grey40
import com.example.metroapp.ui.theme.metroColorPri

@Composable
fun CardStation(
    state: UIState,
    viewModel: MetroViewModel,
    navController: NavController,
    modifier: Modifier = Modifier
) {
    Box(
        modifier = Modifier.fillMaxWidth()
            .padding(vertical = 50.dp),
        contentAlignment = Alignment.Center

    ) {
        Card(
            shape = RoundedCornerShape(12.dp),
            modifier = Modifier
        ) {
            Column(
                modifier = Modifier
                    .background(color = Grey40)
                    .padding(16.dp),
                horizontalAlignment = Alignment.Start
            ) {
                // Source
                Text("Source",
                    style = TextStyle(
                        fontSize = 16.sp,
                        color = metroColorPri
                    ),
                    fontWeight = FontWeight.Bold)
                Spacer(modifier = Modifier.height(8.dp))
                val state by viewModel.uiState.collectAsState()
                DropDownStations(
                    value = state.startStation,
                    stations = state.stations,
                    label = "Select Start Station",
                    onStationSelected = { viewModel.updateStartStation(it) }
                )
                Spacer(modifier = Modifier.height(16.dp))

                // Destination
                Text("Destination",
                    fontWeight = FontWeight.Bold,
                    style = TextStyle(
                        fontSize = 16.sp,
                        color = metroColorPri
                    )
                )
                Spacer(modifier = Modifier.height(8.dp))
                DropDownStations(
                    value = state.endStation,
                    stations = state.stations,
                    label = "Select End Station",
                    onStationSelected = { viewModel.updateEndStation(it) }
                )
                Spacer(modifier = Modifier.height(44.dp))

                viewModel.calculateRoute()

                Button(
                    onClick = {
                        navController.navigate(
                            ResultRoute(
                            startStation = state.startStation,
                            endStation = state.endStation
                        ))
                    },
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(60.dp),
                    colors = ButtonDefaults.buttonColors(metroColorPri),
                    shape = RoundedCornerShape(22.dp),
                    elevation = ButtonDefaults.buttonElevation(4.dp)
                ) {
                    Text(
                        "Find Best Route",
                        fontWeight = FontWeight.Bold,
                        style = TextStyle(
                            fontSize = 18.sp,
                        ),
                        letterSpacing = 0.5.sp
                    )
                }
            }
        }
    }
}