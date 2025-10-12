package com.example.androidlearning

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.compose.rememberNavController
import com.androidlearning.jetpackcomposeessentials.initial.navigation.JCEInitialNavigationImpl
import com.androidlearning.navigation.AppNavGraph
import com.androidlearning.navigation.AppNavOptions
import com.androidlearning.navigation.AppNavigator
import com.androidlearning.navigation.Destination
import com.androidlearning.navigation.NavigationApi
import com.androidlearning.screens.androidlearning.navigation.AndroidLearningNavigationImpl
import com.androidlearning.screens.firstscreen.navigation.FirstScreenNavigationImpl
import com.androidlearning.screens.initial.navigation.InitialScreenNavigationImpl
import com.androidlearning.screens.kotlinlearning.coroutines.navigation.CoroutinesNavigationImpl
import com.androidlearning.screens.kotlinlearning.designpatterns.abstractfactory.navigation.AbstractFactoryNavigationImpl
import com.androidlearning.screens.kotlinlearning.designpatterns.adapter.navigation.AdapterPatternNavigationImpl
import com.androidlearning.screens.kotlinlearning.designpatterns.factorymethod.navigation.FactoryMethodPatternNavigationImpl
import com.androidlearning.screens.kotlinlearning.designpatterns.navigation.DesignPatternsNavigationImpl
import com.androidlearning.screens.kotlinlearning.designpatterns.observer.navigation.ObserverPatternNavigationImpl
import com.androidlearning.screens.kotlinlearning.designpatterns.state.navigation.StatePatternNavigationImpl
import com.androidlearning.screens.kotlinlearning.navigation.KotlinLearningNavigationImpl
import com.androidlearning.screens.secondscreen.navigation.SecondScreenNavigationImpl

class MainActivity : AppCompatActivity() {

    private val navigationApis: List<NavigationApi> = listOf(
        InitialScreenNavigationImpl(),
        KotlinLearningNavigationImpl(),
        AndroidLearningNavigationImpl(),
        DesignPatternsNavigationImpl(),
        ObserverPatternNavigationImpl(),
        FactoryMethodPatternNavigationImpl(),
        AbstractFactoryNavigationImpl(),
        AdapterPatternNavigationImpl(),
        StatePatternNavigationImpl(),
        CoroutinesNavigationImpl(),
        FirstScreenNavigationImpl(),
        SecondScreenNavigationImpl(),
        JCEInitialNavigationImpl()
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
                startDestination = Destination.InitialScreen,
                navigationApis = navigationApis,
                appNavigator = appNavigator
            )
        }
    }

}