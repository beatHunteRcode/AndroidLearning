package com.example.androidlearning

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.compose.rememberNavController
import com.androidlearning.jetpackcomposeessentials.chapter20.navigation.JCEChapter20NavigationImpl
import com.androidlearning.jetpackcomposeessentials.chapter21.navigation.JCEChapter21NavigationImpl
import com.androidlearning.jetpackcomposeessentials.chapter22.navigation.JCEChapter22NavigationImpl
import com.androidlearning.jetpackcomposeessentials.chapter35.navigation.JCEChapter35NavigationImpl
import com.androidlearning.jetpackcomposeessentials.chapter36.navigation.JCEChapter36NavigationImpl
import com.androidlearning.jetpackcomposeessentials.chapter4.navigation.JCEChapter4NavigationImpl
import com.androidlearning.jetpackcomposeessentials.chapter42.navigation.JCEChapter42NavigationImpl
import com.androidlearning.jetpackcomposeessentials.chapter43.navigation.JCEChapter43NavigationImpl
import com.androidlearning.jetpackcomposeessentials.initial.navigation.JCEInitialNavigationImpl
import com.androidlearning.navigation.AppNavGraph
import com.androidlearning.navigation.AppNavOptions
import com.androidlearning.navigation.AppNavigator
import com.androidlearning.navigation.Destination
import com.androidlearning.navigation.NavigationApi
import com.androidlearning.screens.androidlearning.navigation.AndroidLearningNavigationImpl
import com.androidlearning.screens.androidlearning.screens.anrexample.navigation.ANRExampleNavigationImpl
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
        JCEInitialNavigationImpl(),
        JCEChapter4NavigationImpl(),
        JCEChapter20NavigationImpl(),
        JCEChapter21NavigationImpl(),
        JCEChapter22NavigationImpl(),
        JCEChapter35NavigationImpl(),
        JCEChapter36NavigationImpl(),
        JCEChapter42NavigationImpl(),
        JCEChapter43NavigationImpl(),
        ANRExampleNavigationImpl()
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