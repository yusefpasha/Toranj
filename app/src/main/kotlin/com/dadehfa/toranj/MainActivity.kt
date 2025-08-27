package com.dadehfa.toranj

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.navigation.compose.rememberNavController
import com.dadehfa.toranj.common.ui.theme.ToranjTheme
import com.dadehfa.toranj.presentation.MainScreen

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val navGraph = rememberNavController()
            ToranjTheme {
                MainScreen(navGraph = navGraph)
            }
        }
    }
}
