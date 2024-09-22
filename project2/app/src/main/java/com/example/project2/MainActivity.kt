package com.example.project2

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.compose.rememberNavController
import com.example.project2.navigation.MainNav
import com.example.project2.ui.theme.Project2Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Project2Theme {
                val navController = rememberNavController()
                MainNav(navHostController = navController)
            }
        }
    }
}
