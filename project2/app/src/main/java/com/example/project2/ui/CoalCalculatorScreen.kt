package com.example.project2.ui

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableDoubleStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.project2.utils.Utils

private const val COAL_LOWER_CALORIFIC_VALUE = 20.47
private const val COAL_FRACTION_OF_FLY_ASH = 0.8
private const val COAL_ASH = 25.20
private const val COAL_COMBUSTIBLE_SUBSTANCES = 1.5
private const val EFFICIENCY_OF_FLUE_GAS_PURIFICATION = 0.985
private const val EMISSION_INDEX = 0.0

@Composable
fun CoalCalculatorScreen(navController: NavHostController) {
    var coalMass by remember { mutableStateOf("") }
    var emission by remember { mutableDoubleStateOf(0.0) }
    var grossEmission by remember { mutableDoubleStateOf(0.0) }

    Column(
        modifier = Modifier.fillMaxSize().padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text("Калькулятор валових викидів шкідливих речовин " +
                "у  вигляді суспендованих твердих частинок при спалювання вугілля:",
            style = MaterialTheme.typography.headlineSmall)

        Spacer(modifier = Modifier.height(32.dp))

        OutlinedTextField(
            value = coalMass,
            onValueChange = { coalMass = it },
            label = { Text("Маса донецького газового вугілля марки ГР (т)") }
        )

        Spacer(modifier = Modifier.height(16.dp))

        Button(onClick = {
            emission = Utils.calculateEmission(
                COAL_LOWER_CALORIFIC_VALUE,
                COAL_FRACTION_OF_FLY_ASH,
                COAL_ASH,
                COAL_COMBUSTIBLE_SUBSTANCES
            )

            grossEmission = Utils.calculateGrossEmission(
                emission,
                coalMass.toDouble(),
                COAL_LOWER_CALORIFIC_VALUE
            )
        }) {
            Text("Розрахувати")
        }

        Spacer(modifier = Modifier.height(16.dp))

        Text("Показник емісії твердих частинок при спалюванні вугілля: $emission г/ГДж.\n\n" +
                "Валовий викид при спалюванні вугілля: $grossEmission т.")

        Spacer(modifier = Modifier.height(32.dp))

        Button(onClick = { navController.popBackStack() }) {
            Text("Назад в меню")
        }
    }
}