package com.example.metroapp

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.metroapp.presentation.viewmodel.MetroViewModel
import di.AppModule
import com.example.metroapp.presentation.screens.MetroHomeScreen
import com.example.metroapp.presentation.screens.ResultScreen

class MainActivity : ComponentActivity() {
    @SuppressLint("ViewModelConstructorInComposable")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val viewModel = MetroViewModel(
                findRoute = AppModule.provideFindRoute(this),
                getDirection = AppModule.provideDirection(this),
                getStations = AppModule.provideGetStations(this)
            )
            val navController = rememberNavController()
            NavHost(navController = navController, startDestination = "home") {
                composable("home") {
                    MetroHomeScreen(
                        navController = navController,
                        metroViewModel = viewModel
                    )
                }
                composable("result") {
                    ResultScreen(viewModel)
                }
            }
        }
    }
}



