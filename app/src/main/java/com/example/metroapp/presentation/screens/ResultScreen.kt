package com.example.metroapp.presentation.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.metroapp.presentation.component.MetroTimeline
import com.example.metroapp.presentation.component.WhenError
import com.example.metroapp.presentation.viewmodel.MetroViewModel
import com.example.metroapp.ui.theme.metroColorPri
import domain.model.RouteResult

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ResultScreen(
    viewModel: MetroViewModel,
    navController: NavController,

) {
    val state = viewModel.uiState.collectAsState()
    val result = state.value.result

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Route Details", fontWeight = FontWeight.Bold) },
                navigationIcon = {
                    IconButton(onClick = { navController.navigateUp() }) {
                        Icon(imageVector = Icons.Default.ArrowBack, contentDescription = "Back")
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = Color.White,
                    titleContentColor = metroColorPri,
                    navigationIconContentColor = metroColorPri
                )
            )
        }
    ) { padding ->
        Box(modifier = Modifier.padding(padding).fillMaxSize()) {
            when (result) {
                is RouteResult.Success -> {
                    MetroTimeline(
                        stations = result.stations,
                        fromStation = result.fromStation,
                        toStation = result.toStation,
                        fare = result.fare,
                        totalTime = result.time,
                        totalStations = result.stations.size,
                        lineChanges = result.lineChanges
                    )
                }
                is RouteResult.Error -> {
                    WhenError(result)
                }
                null -> {
                    Box(
                        modifier = Modifier.fillMaxSize(),
                        contentAlignment = Alignment.Center
                    ) {
                        CircularProgressIndicator(color = metroColorPri)
                    }
                }
            }
        }
    }
}