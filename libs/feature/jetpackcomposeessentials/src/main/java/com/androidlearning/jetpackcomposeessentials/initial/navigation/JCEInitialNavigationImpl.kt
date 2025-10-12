package com.androidlearning.jetpackcomposeessentials.initial.navigation

import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import com.androidlearning.jetpackcomposeessentials.initial.JCEInitialScreen
import com.androidlearning.jetpackcomposeessentials.initial.JCEInitialScreenViewModel
import com.androidlearning.navigation.AppNavigator
import com.androidlearning.navigation.Destination
import com.androidlearning.navigation.NavigationApi
import com.androidlearning.navigation.composable

class JCEInitialNavigationImpl : NavigationApi {
    override fun registerGraph(
        modifier: Modifier,
        navGraphBuilder: NavGraphBuilder,
        navController: NavController,
        appNavigator: AppNavigator
    ) {
        navGraphBuilder.composable(
            destination = Destination.JCEInitialScreen
        ) {
            JCEInitialScreen(
                viewModel = JCEInitialScreenViewModel()
            )
        }
    }

}