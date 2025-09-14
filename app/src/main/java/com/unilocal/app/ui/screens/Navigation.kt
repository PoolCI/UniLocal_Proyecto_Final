package com.unilocal.app.ui.screens

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.unilocal.app.ui.config.RouteScreen

@Composable
fun Navigation() {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = RouteScreen.LoginScreen
    ) {
        composable<RouteScreen.LoginScreen> {
            LoginScreen(
                onRegisterClick = { navController.navigate(RouteScreen.RegisterScreen) },
                onChangePasswordClick = { navController.navigate(RouteScreen.ChangePasswordScreen) },
                onLoginSuccess = { navController.navigate(RouteScreen.HomeScreen) }
            )
        }
        composable<RouteScreen.RegisterScreen> {
            RegisterScreen(
                onLoginClick = { navController.navigate(RouteScreen.LoginScreen) }
            )
        }
        composable<RouteScreen.ChangePasswordScreen> {
            ChangePasswordScreen(
                onLoginClick = { navController.navigate(RouteScreen.LoginScreen) }
            )
        }
        composable<RouteScreen.HomeScreen> {
            HomeScreen()
        }
    }
}