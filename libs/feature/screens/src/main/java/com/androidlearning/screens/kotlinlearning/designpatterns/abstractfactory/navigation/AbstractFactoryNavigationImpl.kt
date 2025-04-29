package com.androidlearning.screens.kotlinlearning.designpatterns.abstractfactory.navigation

import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import com.androidlearning.navigation.AppNavigator
import com.androidlearning.navigation.Destination
import com.androidlearning.navigation.NavigationApi
import com.androidlearning.navigation.composable
import com.androidlearning.screens.kotlinlearning.designpatterns.abstractfactory.ui.AbstractFactoryScreen
import com.androidlearning.screens.kotlinlearning.designpatterns.abstractfactory.ui.AbstractFactoryScreenViewModel

class AbstractFactoryNavigationImpl : NavigationApi {
    override fun registerGraph(
        modifier: Modifier,
        navGraphBuilder: NavGraphBuilder,
        navController: NavController,
        appNavigator: AppNavigator
    ) {
        navGraphBuilder.composable(
            destination = Destination.AbstractFactoryPatternScreen
        ) {
            AbstractFactoryScreen(viewModel = AbstractFactoryScreenViewModel())
        }
    }
}