package com.androidlearning.navigation

sealed class Destination(
    protected val route: String,
    vararg args: String
) {
    val fullRoute: String =
        if (args.isEmpty()) {
            route
        } else {
            val builder = StringBuilder(route)
            args.forEach { builder.append("/{${it}}") }
            builder.toString()
        }

    sealed class NoArgumentDestination(route: String) : Destination(route)

    data object FirstScreen : NoArgumentDestination("first_screen")
    data object SecondScreen : NoArgumentDestination("second_screen")
}