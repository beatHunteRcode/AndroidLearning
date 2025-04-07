package com.androidlearning.screens.firstscreen.navigation

import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import com.androidlearning.navigation.AppNavigator
import com.androidlearning.navigation.Destination
import com.androidlearning.navigation.NavigationApi
import com.androidlearning.navigation.composable
import com.androidlearning.screens.firstscreen.FirstScreen
import com.androidlearning.screens.firstscreen.FirstScreenViewModel

class FirstScreenNavigationImpl : NavigationApi {
    override fun registerGraph(
        modifier: Modifier,
        navGraphBuilder: NavGraphBuilder,
        navController: NavController,
        appNavigator: AppNavigator
    ) {
        navGraphBuilder.composable(
            destination = Destination.FirstScreen,
        ) {
            FirstScreen(
                viewModel = FirstScreenViewModel(
                    appNavigator = appNavigator
                )
            )
        }
    }
}