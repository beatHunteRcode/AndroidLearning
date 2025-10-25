package com.androidlearning.jetpackcomposeessentials.chapter22.navigation

import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import com.androidlearning.jetpackcomposeessentials.chapter22.JCEChapter22Screen
import com.androidlearning.navigation.AppNavigator
import com.androidlearning.navigation.Destination
import com.androidlearning.navigation.NavigationApi
import com.androidlearning.navigation.composable

class JCEChapter22NavigationImpl : NavigationApi {
    override fun registerGraph(
        modifier: Modifier,
        navGraphBuilder: NavGraphBuilder,
        navController: NavController,
        appNavigator: AppNavigator
    ) {
        navGraphBuilder.composable(
            destination = Destination.JCEChapter22Screen
        ) {
            JCEChapter22Screen()
        }
    }
}