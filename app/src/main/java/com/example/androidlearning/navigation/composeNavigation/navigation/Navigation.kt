package com.example.androidlearning.navigation.composeNavigation.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.androidlearning.navigation.composeNavigation.ui.FirstFragmentContent
import com.example.androidlearning.navigation.composeNavigation.ui.SecondFragmentContent

@Composable
fun Navigation() {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = NavFragment.FirstFragment.route
    ) {
        val secondFragmentArgName = "inputText"

        composable(route = NavFragment.FirstFragment.route) {
            FirstFragmentContent(navController)
        }
        composable(
            route = NavFragment.SecondFragment.route + "/{$secondFragmentArgName}",
            arguments = listOf(
                navArgument(name = secondFragmentArgName) {
                    type = NavType.StringType
                    nullable = false
                }
            )
        ) { navEntry ->
            SecondFragmentContent(
                navController = navController,
                inputText = navEntry.arguments?.getString(secondFragmentArgName) ?: ""
            )
        }
    }
}