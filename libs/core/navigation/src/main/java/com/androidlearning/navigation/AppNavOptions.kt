package com.androidlearning.navigation

import androidx.activity.compose.LocalActivity
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.navigation.NavHostController
import kotlinx.coroutines.flow.Flow

@Composable
fun AppNavOptions(
    navigationFLow: Flow<NavigationIntent>,
    navController: NavHostController
) {
    val activity = LocalActivity.current
    LaunchedEffect(activity, navigationFLow, navController) {
        navigationFLow.collect { intent ->
            if (activity?.isFinishing == true) {
                return@collect
            }
            when (intent) {
                is NavigationIntent.NavigateTo -> {
                    navController.navigate(intent.route) {
                        intent.popUpToRoute?.let {  popUpToRoute ->
                            popUpTo(popUpToRoute) { inclusive = intent.inclusive }
                        }
                    }
                }
            }
        }
    }
}