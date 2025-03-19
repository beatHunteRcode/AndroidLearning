package com.example.androidlearning.google_codelabs.navigation

import androidx.compose.ui.graphics.vector.ImageVector

data class BottomNavItem(
    val name: String,
    val icon: ImageVector,
    val route: String,
    val testTag: String
)

