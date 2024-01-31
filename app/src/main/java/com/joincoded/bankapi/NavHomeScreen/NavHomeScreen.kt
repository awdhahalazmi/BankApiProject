package com.joincoded.bankapi.NavHomeScreen

import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.joincoded.bankapi.composableApi.SignUpScreen
import com.joincoded.bankapi.composableApi.WelcomeScreen

@Composable
fun NavScreen(){
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "WelcomeScreen"){
        composable("WelcomeScreen"){
            WelcomeScreen(navController = navController)
        }
        composable("signupRoute"){
            SignUpScreen()
        }
    }
}