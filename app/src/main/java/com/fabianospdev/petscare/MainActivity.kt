package com.fabianospdev.petscare

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.fabianospdev.petscare.presenter.ui.home.HomeScreen
import com.fabianospdev.petscare.presenter.ui.login.LoginScreen
import com.fabianospdev.petscare.presenter.ui.settings.SettingsScreen
import com.fabianospdev.petscare.presenter.ui.theme.PetsCareTheme
import dagger.hilt.android.AndroidEntryPoint

val montserratFamily = FontFamily(
    Font(R.font.montserrat_light, FontWeight.Light),
    Font(R.font.montserrat_regular, FontWeight.Normal),
    Font(R.font.montserrat_medium, FontWeight.Medium),
    Font(R.font.montserrat_semibold, FontWeight.Bold)
)

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    private lateinit var navController: NavHostController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            PetsCareTheme {
                val context = applicationContext
                Surface(modifier = Modifier.fillMaxSize(), color = Color.Transparent) {
                    navController = rememberNavController()
                    NavHost(navController = navController, startDestination = "login") {
                        composable("login") {
                            LoginScreen(navController = navController, name = "Login", context = context)
                        }
                        composable("home") {
                            HomeScreen(navController = navController, name = "Home", context = context)
                        }
                        composable("settings") {
                            SettingsScreen(navController = navController, name = "Settings", context = context)
                        }
                    }
                }
            }
        }
    }
}

