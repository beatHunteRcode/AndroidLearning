package com.example.androidlearning

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.compose.rememberNavController
import com.androidlearning.navigation.AppNavGraph
import com.androidlearning.navigation.AppNavOptions
import com.androidlearning.navigation.AppNavigator
import com.androidlearning.navigation.Destination
import com.androidlearning.navigation.NavigationApi
import com.androidlearning.screens.firstscreen.navigation.FirstScreenNavigationImpl
import com.androidlearning.screens.secondscreen.navigation.SecondScreenNavigationImpl

class MainActivity : AppCompatActivity() {

    private val navigationApis: List<NavigationApi> = listOf(
        FirstScreenNavigationImpl(),
        SecondScreenNavigationImpl()
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            val navController = rememberNavController()
            val appNavigator = AppNavigator()

            AppNavOptions(
                navigationFLow = appNavigator.navigationFlow,
                navController = navController
            )

            AppNavGraph(
                navController = navController,
                startDestination = Destination.FirstScreen,
                navigationApis = navigationApis,
                appNavigator = appNavigator
            )
        }
    }

}