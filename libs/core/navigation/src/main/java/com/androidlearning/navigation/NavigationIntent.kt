package com.androidlearning.navigation

sealed class NavigationIntent {
    data class NavigateTo(
        val route: String,
        val popUpToRoute: String? = null,
        val inclusive: Boolean = false
    ) : NavigationIntent()
}