package com.example.metroapp

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.remember
import com.example.metroapp.presentation.navigation.NavHost
import com.example.metroapp.presentation.viewmodel.MetroViewModel
import di.AppModule
import com.example.metroapp.ui.theme.MetroAppTheme

class MainActivity : ComponentActivity() {
    @SuppressLint("ViewModelConstructorInComposable")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MetroAppTheme {
                val viewModel = remember {
                    MetroViewModel(
                        findRoute = AppModule.provideFindRoute(this),
                        getDirection = AppModule.provideDirection(this),
                        getStations = AppModule.provideGetStations(this)
                    )
                }
                NavHost(viewModel)
            }
        }
    }
}