package com.example.project2.ui

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainScreen(navController: NavHostController) {
    Scaffold(
        topBar = {
            TopAppBar(title = { Text("Практична робота №2\nСидоренко Дар'ї") })
        },
        content = { paddingValues ->
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(paddingValues)
                    .padding(16.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                Text(
                    text = "Калькулятори для розрахунку валових викидів шкідливих речовин " +
                            "у  вигляді суспендованих твердих частинок при спалюванні:"
                )
                Spacer(modifier = Modifier.height(16.dp))
                Button(
                    onClick = { navController.navigate("coal_calculator") },
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Text("Вугілля")
                }
                Spacer(modifier = Modifier.height(16.dp))
                Button(
                    onClick = { navController.navigate("oil_calculator") },
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Text("Мазуту")
                }
                Spacer(modifier = Modifier.height(16.dp))
                Button(
                    onClick = { navController.navigate("gas_calculator") },
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Text("Природного газу")
                }
            }
        }
    )
}
