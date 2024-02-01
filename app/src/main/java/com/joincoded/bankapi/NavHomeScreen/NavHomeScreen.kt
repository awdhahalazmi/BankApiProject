package com.joincoded.bankapi.NavHomeScreen

import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.joincoded.bankapi.composableApi.BankMainScreen
import com.joincoded.bankapi.composableApi.DepositeScreen
import com.joincoded.bankapi.composableApi.SignUpScreen
import com.joincoded.bankapi.composableApi.WelcomeScreen
import com.joincoded.bankapi.composableApi.WithdrawScreen
import com.joincoded.bankapi.utils.Routes.Companion.depositRoute
import com.joincoded.bankapi.utils.Routes.Companion.loginRoute
import com.joincoded.bankapi.utils.Routes.Companion.signupRoute
import com.joincoded.bankapi.utils.Routes.Companion.welcomeScreenRoute
import com.joincoded.bankapi.utils.Routes.Companion.withdrawRoute
import com.joincoded.bankapi.viewModel.BankViewModel

@Composable
fun NavScreen() {
    val navController = rememberNavController()
    val viewModel: BankViewModel = viewModel()


    var startDestination = welcomeScreenRoute
    if (viewModel.token?.token != null) {
        startDestination = loginRoute
        navController.navigate(loginRoute)
    }


    NavHost(navController = navController, startDestination = startDestination) {
        composable(welcomeScreenRoute) {
            WelcomeScreen(navController = navController, viewModel)
        }

        composable(signupRoute) {
            SignUpScreen(viewModel)
        }

        composable(loginRoute){
            BankMainScreen(navController = navController, viewModel)
        }

        composable(depositRoute){
            DepositeScreen(navController = navController, viewModel)
        }

        composable(withdrawRoute){
            WithdrawScreen(navController = navController, viewModel)
        }
    }
}