package com.unilocal.app.ui.config

import kotlinx.serialization.Serializable

sealed class  RouteScreen(){

    @Serializable
    data object LoginScreen : RouteScreen()

    @Serializable
    data object RegisterScreen : RouteScreen()

    @Serializable
    data object ChangePasswordScreen : RouteScreen()

    @Serializable
    data object HomeScreen : RouteScreen()

}