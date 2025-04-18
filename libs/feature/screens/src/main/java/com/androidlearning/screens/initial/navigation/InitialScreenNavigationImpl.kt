package com.androidlearning.screens.initial.navigation

import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import com.androidlearning.navigation.AppNavigator
import com.androidlearning.navigation.Destination
import com.androidlearning.navigation.NavigationApi
import com.androidlearning.navigation.composable
import com.androidlearning.screens.initial.InitialScreen
import com.androidlearning.screens.initial.InitialScreenViewModel

class InitialScreenNavigationImpl : NavigationApi {
    override fun registerGraph(
        modifier: Modifier,
        navGraphBuilder: NavGraphBuilder,
        navController: NavController,
        appNavigator: AppNavigator
    ) {
        navGraphBuilder.composable(
            destination = Destination.InitialScreen
        ) {
            InitialScreen(
                viewModel = InitialScreenViewModel(
                    appNavigator = appNavigator
                )
            )
        }
    }
}