package com.example.androidlearning.navigation.navigationComponent

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.fragment.NavHostFragment
import com.example.androidlearning.R

/**
 * Reference: [Navigation Component with Jetpack Compose](https://youtu.be/4ljGUQTxVJQ)
 *
 * Before run App, change activity in AndroidManifest to [MainActivityNavigation]
 */
class MainActivityNavigation : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.main_activity_navigation_layout)

        val navController = (supportFragmentManager
            .findFragmentById(R.id.navigation_learning_nav_host_fragment) as NavHostFragment)
            .navController

        navController.graph = navController.navInflater.inflate(R.navigation.learning_navigation_graph)
        navController.graph.setStartDestination(R.id.firstFragment)
    }

}