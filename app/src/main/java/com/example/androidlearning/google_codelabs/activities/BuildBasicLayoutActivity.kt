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
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.List
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
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
import com.example.androidlearning.google_codelabs.navigation.screens.build_basic_layout.BirthdayCardScreen
import com.example.androidlearning.google_codelabs.navigation.screens.build_basic_layout.BusinessCardScreen
import com.example.androidlearning.google_codelabs.navigation.screens.build_basic_layout.ComposeArticleScreen
import com.example.androidlearning.google_codelabs.navigation.screens.build_basic_layout.ComposeQuadrantScreen
import com.example.androidlearning.google_codelabs.navigation.screens.build_basic_layout.TaskManagerScreen
import com.example.androidlearning.google_codelabs.theme.ComposeBasicsTheme

class BuildBasicLayoutActivity : ComponentActivity() {

    object Routes {
        const val ROUTE_TO_BUSINESS_CARD_SCREEN = "business_card"
        const val ROUTE_TO_BIRTHDAY_CARD_SCREEN = "birthday_card"
        const val ROUTE_TO_COMPOSE_ARTICLE_SCREEN = "compose_article"
        const val ROUTE_TO_TASK_MANAGER_SCREE = "task_manager"
        const val ROUTE_TO_COMPOSE_QUADRANT_SCREEN = "compose_quadrant"
    }


    object Utils {
        val bottomNavItemsList = listOf<BottomNavItem>(
            BottomNavItem(
                "Business Card",
                Icons.Filled.Person,
                route = Routes.ROUTE_TO_BUSINESS_CARD_SCREEN,
                testTag = C.Tag.buildBasicLayoutActivity_bottom_bar_business_card_item
            ),
            BottomNavItem(
                "Birthday Card",
                Icons.Filled.Star,
                route = Routes.ROUTE_TO_BIRTHDAY_CARD_SCREEN,
                testTag = C.Tag.buildBasicLayoutActivity_bottom_bar_birthday_card_item
            ),
            BottomNavItem(
                "Compose Article",
                Icons.Filled.Info,
                route = Routes.ROUTE_TO_COMPOSE_ARTICLE_SCREEN,
                testTag = C.Tag.buildBasicLayoutActivity_bottom_bar_compose_article_item
            ),
            BottomNavItem(
                "Task Manager",
                Icons.Filled.CheckCircle,
                route = Routes.ROUTE_TO_TASK_MANAGER_SCREE,
                testTag = C.Tag.buildBasicLayoutActivity_bottom_bar_task_manager_item
            ),
            BottomNavItem(
                "Compose Quadrant",
                Icons.Filled.List,
                route = Routes.ROUTE_TO_COMPOSE_QUADRANT_SCREEN,
                testTag = C.Tag.buildBasicLayoutActivity_bottom_bar_compose_quadrant_item
            )
        )
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeBasicsTheme {
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
    }

    @Composable
    fun NavHostContainer(
        navController: NavHostController,
        padding: PaddingValues
    ) {
        NavHost(
            navController = navController,
            startDestination = Routes.ROUTE_TO_BUSINESS_CARD_SCREEN,
            modifier = Modifier.padding(paddingValues = padding),
            builder = {
                composable(Routes.ROUTE_TO_BUSINESS_CARD_SCREEN) {
                    BusinessCardScreen()
                }
                composable(Routes.ROUTE_TO_BIRTHDAY_CARD_SCREEN) {
                    BirthdayCardScreen()
                }
                composable(Routes.ROUTE_TO_COMPOSE_ARTICLE_SCREEN) {
                    ComposeArticleScreen()
                }
                composable(Routes.ROUTE_TO_TASK_MANAGER_SCREE) {
                    TaskManagerScreen()
                }
                composable(Routes.ROUTE_TO_COMPOSE_QUADRANT_SCREEN) {
                    ComposeQuadrantScreen()
                }
            }
        )
    }

    @Composable
    fun TopBar() {
        TopAppBar(backgroundColor = Color(0xFF9575CD)) {
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
            backgroundColor = Color(0xFF9575CD)
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