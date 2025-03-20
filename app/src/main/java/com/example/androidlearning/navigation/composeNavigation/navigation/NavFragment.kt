package com.example.androidlearning.navigation.composeNavigation.navigation

sealed class NavFragment(val route: String) {
    data object FirstFragment : NavFragment("first_fragment")
    data object SecondFragment : NavFragment("second_fragment")

    fun withArgs(vararg args: String): String {
        return buildString {
            append(route)
            args.forEach { arg ->
                append("/$arg")
            }
        }
    }
}