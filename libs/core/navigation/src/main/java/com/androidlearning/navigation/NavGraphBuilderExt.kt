package com.androidlearning.navigation

import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder

fun NavGraphBuilder.register(
    modifier: Modifier = Modifier,
    navigationApi: NavigationApi,
    navController: NavController,
    appNavigator: AppNavigator
) {
    navigationApi.registerGraph(
        modifier = modifier,
        navGraphBuilder = this,
        navController = navController,
        appNavigator = appNavigator
    )
}