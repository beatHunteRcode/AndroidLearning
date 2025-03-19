package com.example.androidlearning.google_codelabs.activities

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Face
import androidx.compose.material.icons.filled.List
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.semantics.testTag
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.androidlearning.google_codelabs.C
import com.example.androidlearning.google_codelabs.navigation.BottomNavItem
import com.example.androidlearning.google_codelabs.navigation.screens.compose_essentials.MySootheScreen
import com.example.androidlearning.google_codelabs.navigation.screens.compose_essentials.WellnessScreen

class ComposeEssentialsActivity : ComponentActivity() {

    object Routes {
        const val ROUTE_TO_MY_SOOTHE_SCREEN = "my_soothe"
        const val ROUTE_TO_WELLNESS_SCREEN = "wellness"
    }

    object Utils {
        val bottomNavItemsList = listOf<BottomNavItem>(
            BottomNavItem(
                "My Soothe",
                Icons.Filled.Face,
                route = Routes.ROUTE_TO_MY_SOOTHE_SCREEN,
                testTag = C.Tag.composeEssentials_bottom_bar_my_soothe_item
            ),
            BottomNavItem(
                "Wellness",
                Icons.Filled.List,
                route = Routes.ROUTE_TO_WELLNESS_SCREEN,
                testTag = C.Tag.composeEssentials_bottom_bar_wellness_item
            )
        )
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val navController = rememberNavController()
            Scaffold(
                topBar = {
                    TopBar()
                },
                bottomBar = {
                    BottomNavigationBar(navController = navController)
                },
                content = { paddingValues ->
                    NavHostContainer(
                        navController = navController,
                        padding = paddingValues
                    )
                }
            )
        }
    }


    @Composable
    fun NavHostContainer(
        navController: NavHostController,
        padding: PaddingValues
    ) {
        NavHost(
            navController = navController,
            startDestination = Routes.ROUTE_TO_MY_SOOTHE_SCREEN,
            modifier = Modifier.padding(paddingValues = padding),
            builder = {
                composable(Routes.ROUTE_TO_MY_SOOTHE_SCREEN) {
                    MySootheScreen()
                }
                composable(Routes.ROUTE_TO_WELLNESS_SCREEN) {
                    WellnessScreen()
                }
            }
        )
    }

    @Composable
    fun TopBar() {
        TopAppBar(backgroundColor = MaterialTheme.colorScheme.background) {
            val context = LocalContext.current
            IconButton(onClick = {
                context.startActivity(Intent(context, MainActivity::class.java))
            }) {
                Icon(Icons.Filled.ArrowBack, contentDescription = "Back To Main Screen")
            }
        }
    }

    @Composable
    fun BottomNavigationBar(navController: NavHostController) {
        BottomNavigation(
            backgroundColor = MaterialTheme.colorScheme.background
        ) {
            val navBackStackEntry by navController.currentBackStackEntryAsState()
            val currentRoute = navBackStackEntry?.destination?.route
            Utils.bottomNavItemsList.forEach { bottomNavItem ->
                BottomNavigationItem(
                    selected = currentRoute == bottomNavItem.route,
                    onClick = {
                        navController.navigate(bottomNavItem.route)
                    },
                    icon = {
                        Icon(
                            imageVector = bottomNavItem.icon,
                            contentDescription = bottomNavItem.name
                        )
                    },
                    label = {
                        Text(
                            text = bottomNavItem.name,
                            fontSize = 8.sp
                        )
                    },
                    modifier = Modifier.semantics { testTag = bottomNavItem.testTag }
                )
            }
        }
    }
}