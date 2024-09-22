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

private const val OIL_LOWER_CALORIFIC_VALUE = 39.48
private const val OIL_FRACTION_OF_FLY_ASH = 1.0
private const val OIL_ASH = 0.15
private const val OIL_COMBUSTIBLE_SUBSTANCES = 0.0
private const val EFFICIENCY_OF_FLUE_GAS_PURIFICATION = 0.985
private const val EMISSION_INDEX = 0.0

@Composable
fun OilCalculatorScreen(navController: NavHostController) {
    var oilMass by remember { mutableStateOf("") }
    var emission by remember { mutableDoubleStateOf(0.0) }
    var grossEmission by remember { mutableDoubleStateOf(0.0) }

    Column(
        modifier = Modifier.fillMaxSize().padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text("Калькулятор валових викидів шкідливих речовин " +
                "у  вигляді суспендованих твердих частинок при спалювання мазуту:",
            style = MaterialTheme.typography.headlineSmall)

        Spacer(modifier = Modifier.height(32.dp))

        OutlinedTextField(
            value = oilMass,
            onValueChange = { oilMass = it },
            label = { Text("Маса високосірчастого мазуту марки 40 (т)") }
        )

        Spacer(modifier = Modifier.height(16.dp))

        Button(onClick = {
            emission = Utils.calculateEmission(
                OIL_LOWER_CALORIFIC_VALUE,
                OIL_FRACTION_OF_FLY_ASH,
                OIL_ASH,
                OIL_COMBUSTIBLE_SUBSTANCES
            )
            grossEmission = Utils.calculateGrossEmission(
                emission,
                OIL_LOWER_CALORIFIC_VALUE,
                oilMass.toDouble()
            )
        }) {
            Text("Розрахувати")
        }

        Spacer(modifier = Modifier.height(16.dp))

        Text("Показник емісії твердих частинок при спалюванні мазуту: $emission г/ГДж.\n\n" +
                "Валовий викид при спалюванні мазуту: $grossEmission т.")

        Spacer(modifier = Modifier.height(32.dp))

        Button(onClick = { navController.popBackStack() }) {
            Text("Назад в меню")
        }
    }
}