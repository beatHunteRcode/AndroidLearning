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

    data object AndroidLearningScreen : NoArgumentDestination("android_learning")
    data object ANRExampleScreen : NoArgumentDestination("anr_example")
    data object JCEInitialScreen: NoArgumentDestination("JCE_initial")
    data object JCEChapter4Screen: NoArgumentDestination("JCE_chapter_4")
    data object JCEChapter20Screen: NoArgumentDestination("JCE_chapter_20")
    data object JCEChapter21Screen: NoArgumentDestination("JCE_chapter_21")
    data object JCEChapter22Screen: NoArgumentDestination("JCE_chapter_22")
    data object JCEChapter35Screen: NoArgumentDestination("JCE_chapter_35")
    data object JCEChapter36Screen: NoArgumentDestination("JCE_chapter_36")
    data object JCEChapter42Screen: NoArgumentDestination("JCE_chapter_42")
    data object JCEChapter43Screen: NoArgumentDestination("JCE_chapter_43")

    data object FirstScreen : NoArgumentDestination("first_screen")
    data object SecondScreen : NoArgumentDestination("second_screen")
}