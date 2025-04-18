package com.androidlearning.screens.kotlinlearning.designpatterns.navigation

import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import com.androidlearning.navigation.AppNavigator
import com.androidlearning.navigation.Destination
import com.androidlearning.navigation.NavigationApi
import com.androidlearning.navigation.composable
import com.androidlearning.screens.kotlinlearning.designpatterns.DesignPatternsScreen
import com.androidlearning.screens.kotlinlearning.designpatterns.DesignPatternsScreenViewModel

class DesignPatternsNavigationImpl : NavigationApi {
    override fun registerGraph(
        modifier: Modifier,
        navGraphBuilder: NavGraphBuilder,
        navController: NavController,
        appNavigator: AppNavigator
    ) {
        navGraphBuilder.composable(
            destination = Destination.DesignPatternsScreen
        ) {
            DesignPatternsScreen(viewModel = DesignPatternsScreenViewModel(appNavigator))
        }
    }
}