package com.example.metroapp.presentation.component

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
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.metroapp.presentation.viewmodel.MetroViewModel
import com.example.metroapp.ui.theme.Grey40
import com.example.metroapp.ui.theme.Grey80
import com.example.metroapp.ui.theme.Purple40
import com.example.metroapp.ui.theme.metroColorPri

@Composable
fun CardStation(
    viewModel: MetroViewModel,
    navController: NavController,
    modifier: Modifier = Modifier
) {
    Box(
        modifier = Modifier.fillMaxWidth()
            .padding(vertical = 60.dp),
        contentAlignment = Alignment.Center

    ) {
        Card(
            shape = RoundedCornerShape(12.dp),
            modifier = Modifier
        ) {
            Column(
                modifier = Modifier
                    .background(Grey40)
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
                DropDownStations(
                    value = viewModel.startStation,
                    stations = viewModel.stations,
                    label = "Select Start Station",
                    onStationSelected = { viewModel.startStation = it }
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
                    value = viewModel.endStation,
                    stations = viewModel.stations,
                    label = "Select End Station",
                    onStationSelected = { viewModel.endStation = it }
                )
                Spacer(modifier = Modifier.height(44.dp))

                // Find Best Route Button
                Button(
                    onClick = {
                        viewModel.calculateRoute()
                        navController.navigate("result")
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