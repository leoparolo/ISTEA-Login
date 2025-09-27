package com.example.istea_login

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.istea_login.ui.theme.ISTEALoginTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ISTEALoginTheme {
                val navController = rememberNavController()

                NavHost(navController, startDestination = "login") {
                    composable("login") {
                        LoginPage(
                            navController = navController,
                            demoUser = User("pedro@pe.com.ar", "abc123", "Pedro Pe")
                        )
                    }
                    composable("inicio/{name}") { backstackEntry ->
                        val name = backstackEntry.arguments?.getString("name") ?: ""
                        InicioPage(name = name)
                    }
                }
            }
        }
    }
}