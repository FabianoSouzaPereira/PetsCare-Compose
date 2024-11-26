package com.example.petscompose_class

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.petscompose_class.presenter.ui.home.HomeScreen
import com.example.petscompose_class.presenter.ui.login.LoginScreen
import com.example.petscompose_class.presenter.ui.settings.SettingsScreen
import com.example.petscompose_class.presenter.ui.theme.AppTheme
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    private lateinit var navController: NavHostController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val context = applicationContext
            Surface(modifier = Modifier.fillMaxSize(), color = Color.Transparent, tonalElevation = 5.dp) {
                AppTheme {
                    navController = rememberNavController()
                    NavHost(navController = navController, startDestination = context.getString(R.string.login)) {
                        composable(context.getString(R.string.login)) {
                            LoginScreen(navController = navController, name = context.getString(R.string.login))
                        }
                        composable(context.getString(R.string.home)) {
                            HomeScreen(navController = navController, name = context.getString(R.string.home))
                        }
                        composable(context.getString(R.string.settings)) {
                            SettingsScreen(navController = navController, name = context.getString(R.string.settings))
                        }
                    }
                }
            }
        }
    }
}

