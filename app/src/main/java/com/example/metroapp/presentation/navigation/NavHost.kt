package com.example.metroapp.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.toRoute
import com.example.metroapp.presentation.screens.MetroHomeScreen
import com.example.metroapp.presentation.screens.ResultScreen
import com.example.metroapp.presentation.viewmodel.MetroViewModel

@Composable
fun NavHost(
    viewModel : MetroViewModel
){
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = HomeRoute
    ) {
        composable<HomeRoute> {
            MetroHomeScreen(navController = navController, metroViewModel = viewModel)
        }
        composable<ResultRoute> { backStackEntry ->

            ResultScreen(
                viewModel = viewModel,
                navController = navController
            )
        }
    }
}