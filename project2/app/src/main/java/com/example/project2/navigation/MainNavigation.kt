package com.example.project2.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.project2.ui.MainScreen
import com.example.project2.ui.CoalCalculatorScreen
import com.example.project2.ui.OilCalculatorScreen
import com.example.project2.ui.GasCalculatorScreen

@Composable
fun MainNav(
    modifier: Modifier = Modifier,
    navHostController: NavHostController
) {
    NavHost(
        navController = navHostController,
        startDestination = "main",
        modifier = modifier
    ) {
        composable(route = "main") {
            MainScreen(navController = navHostController)
        }

        composable(route = "coal_calculator") {
            CoalCalculatorScreen(navController = navHostController)
        }

        composable(route = "oil_calculator") {
            OilCalculatorScreen(navController = navHostController)
        }

        composable(route = "gas_calculator") {
            GasCalculatorScreen(navController = navHostController)
        }
    }
}
