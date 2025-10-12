package com.androidlearning.screens.androidlearning.navigation

import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import com.androidlearning.navigation.AppNavigator
import com.androidlearning.navigation.Destination
import com.androidlearning.navigation.NavigationApi
import com.androidlearning.navigation.composable
import com.androidlearning.screens.androidlearning.AndroidLearningScreen
import com.androidlearning.screens.androidlearning.AndroidLearningScreenViewModel

class AndroidLearningNavigationImpl : NavigationApi {
    override fun registerGraph(
        modifier: Modifier,
        navGraphBuilder: NavGraphBuilder,
        navController: NavController,
        appNavigator: AppNavigator
    ) {
        navGraphBuilder.composable(
            destination = Destination.AndroidLearningScreen
        ) {
            AndroidLearningScreen(
                viewModel = AndroidLearningScreenViewModel(
                    appNavigator = appNavigator
                )
            )
        }
    }
}