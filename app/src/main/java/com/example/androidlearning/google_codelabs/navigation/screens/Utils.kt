package com.example.androidlearning.google_codelabs.navigation.screens

import androidx.compose.ui.unit.sp

object Utils {
    const val ARTICLE_TOPIC_STRING = "Jetpack Compose tutorial"
    const val ARTICLE_FIRST_PARAGRAPH_STRING =
        "Jetpack Compose is a modern toolkit for building native Android UI. " +
                "Compose simplifies and accelerates UI development on Android with less code, powerful " +
                "tools, and intuitive Kotlin APIs."
    const val ARTICLE_SECOND_PARAGRAPH_STRING =
        "In this tutorial, you build a simple UI component with declarative functions. " +
                "You call Compose functions to say what elements you want and the Compose compiler " +
                "does the rest. Compose is built around Composable functions. These functions let " +
                "you define your app\\'s UI programmatically because they let you describe how it " +
                "should look and provide data dependencies, rather than focus on the process of " +
                "the UI\\'s construction, such as initializing an element and then attaching it " +
                "to a parent. To create a Composable function, you add the @Composable annotation " +
                "to the function name."
    const val TASK_MANAGER_FIRST_TEXT = "All tasks completed"
    const val TASK_MANAGER_SECOND_TEXT = "Nice work!"

    const val QUADRANT_TEXT_COMPOSABLE_TITLE = "Text composable"
    const val QUADRANT_TEXT_COMPOSABLE_TEXT = "Displays text and follows the recommended Material Design guidelines."
    const val QUADRANT_IMAGE_COMPOSABLE_TITLE = "Image composable"
    const val QUADRANT_IMAGE_COMPOSABLE_TEXT = "Creates a composable that lays out and draws a given Painter class object."
    const val QUADRANT_ROW_COMPOSABLE_TITLE = "Row composable"
    const val QUADRANT_ROW_COMPOSABLE_TEXT = "A layout composable that places its children in a horizontal sequence."
    const val QUADRANT_COLUMN_COMPOSABLE_TITLE = "Column composable"
    const val QUADRANT_COLUMN_COMPOSABLE_TEXT = "A layout composable that places its children in a vertical sequence."

    val DEFAULT_FONT_SIZE = 16.sp
}