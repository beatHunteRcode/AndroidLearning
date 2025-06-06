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

    data object InitialScreen : NoArgumentDestination("initial_screen")
    data object KotlinLearningScreen : NoArgumentDestination("kotlin_learning")
    data object DesignPatternsScreen : NoArgumentDestination("design_patterns")
    data object ObserverPatternScreen : NoArgumentDestination("observer_pattern")
    data object FactoryMethodPatternScreen : NoArgumentDestination("factorymethod_pattern")
    data object AbstractFactoryPatternScreen : NoArgumentDestination("abstractfactory_pattern")
    data object AdapterPatternScreen : NoArgumentDestination("adapter_pattern")
    data object StatePatternScreen : NoArgumentDestination("state_pattern")
    data object CoroutinesScreen : NoArgumentDestination("coroutines")

    data object FirstScreen : NoArgumentDestination("first_screen")
    data object SecondScreen : NoArgumentDestination("second_screen")
}