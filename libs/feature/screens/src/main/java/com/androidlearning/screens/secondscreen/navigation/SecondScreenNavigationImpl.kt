package com.androidlearning.screens.secondscreen.navigation

import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import com.androidlearning.navigation.AppNavigator
import com.androidlearning.navigation.Destination
import com.androidlearning.navigation.NavigationApi
import com.androidlearning.navigation.composable
import com.androidlearning.screens.secondscreen.SecondScreen
import com.androidlearning.screens.secondscreen.SecondScreenViewModel

class SecondScreenNavigationImpl : NavigationApi {
    override fun registerGraph(
        modifier: Modifier,
        navGraphBuilder: NavGraphBuilder,
        navController: NavController,
        appNavigator: AppNavigator
    ) {
        navGraphBuilder.composable(
            destination = Destination.SecondScreen,
        ) {
            SecondScreen(
                viewModel = SecondScreenViewModel(
                    appNavigator = appNavigator
                )
            )
        }
    }
}