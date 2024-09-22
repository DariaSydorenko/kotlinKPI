package com.example.project2.utils
import kotlin.math.pow

object Utils {
    private const val EFFICIENCY_OF_FLUE_GAS_PURIFICATION = 0.985
    private const val EMISSION_INDEX = 0

    fun calculateEmission(
        lowerCalorificValue: Double,
        fractionOfFlyAsh: Double,
        ash: Double,
        combustibleSubstances: Double,
    ): Double {
        return (10.0.pow(6) / lowerCalorificValue) * fractionOfFlyAsh *
                (ash / (100 - combustibleSubstances)) *
                (1 - EFFICIENCY_OF_FLUE_GAS_PURIFICATION) + EMISSION_INDEX
    }

    fun calculateGrossEmission(
        emission: Double,
        mass: Double,
        lowerCalorificValue: Double
    ): Double {
        return 10.0.pow(-6) * emission * lowerCalorificValue * mass
    }
}